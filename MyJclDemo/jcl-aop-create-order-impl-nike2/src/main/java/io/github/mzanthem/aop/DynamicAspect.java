/*
 * DynamicAOP.java Created On 2018年11月28日
 * Copyright(c) 2018 Mazan Inc.
 * ALL Rights Reserved.
 */
package io.github.mzanthem.aop;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import io.github.mzanthem.core.JarClassManager;
import io.github.mzanthem.spring.aop.IDynamicAspect;

/**
 * DynamicAspect
 * AspectJ方式的AOP
 * 加载到项目中 -->继承基类
 * @time: 下午6:04:05
 * @author mazan
 */
public class DynamicAspect implements IDynamicAspect {
	
	private static final String className1 = "io.github.mzanthem.service.impl.CreateOrderServiceImpl";
	private static final String className2 = "io.github.mzanthem.service.impl.MyTestServiceImpl";
	
	/**
	 * 自己实现业务逻辑
	 * @param pjp
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws MyJclException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	@Override
	public boolean execute(String jclName, String methodName, Class<?>[] parameterTypes, Object[] args) throws Exception {
		
		//远程业务
		System.out.println("动态JCL:nike.execute");
		
		// 执行createOrder方法
		
		Map<String, Class<?>> listLoadedClass = JarClassManager.listLoadedClass(jclName);
		for (String clazz : listLoadedClass.keySet()) {
			System.out.println(clazz);
		}
		//构造class1
		Class<?> clazz1 = JarClassManager.getLoadedClass(jclName, className1);
		Object cos = clazz1.newInstance();
		//获得实现类的接口
		Class<?> interfaces[] = clazz1.getInterfaces();
		Class<?> interfaces1 = interfaces[0];
		System.out.println(interfaces1);
		
		//根据类名获取Class对象  构造class2
		Class<?> clazz2 = JarClassManager.getLoadedClass(jclName, className2);
		//参数类型数组
		Class<?>[] parameterTypes2={interfaces1};
		//根据参数类型获取相应的构造函数
		Constructor<?> constructor=clazz2.getConstructor(parameterTypes2);
		//参数数组
		Object[] parameters={cos};
		//根据获取的构造函数和参数，创建实例
		Object mts=constructor.newInstance(parameters);
		System.out.println("---------------");
		
		//反射去执行真正的方法
		Method targetMethod = clazz2.getMethod(methodName, parameterTypes);
		
		
		targetMethod.invoke(mts, args);
		
		return true;
	}
}

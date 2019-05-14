/*
 * DynamicAOP.java Created On 2018年11月28日
 * Copyright(c) 2018 Mazan Inc.
 * ALL Rights Reserved.
 */
package io.github.mzanthem.aop;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

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
	
	private static final String className0 = "io.github.mzanthem.service.impl.MyTestServiceImpl";
	
	private static final String className1 = "io.github.mzanthem.service.impl.CreateOrderServiceImpl";
	private static final String className2 = "io.github.mzanthem.service.impl.AdidasSkuServiceImpl";
	
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
		
		
		
		//构造class1
		Class<?> clazz1 = JarClassManager.getLoadedClass(jclName, className1);
		Object instance1 = clazz1.newInstance();
		//获得实现类的接口
		Class<?>[] interfaces1Arr = clazz1.getInterfaces();
		System.out.println(Arrays.asList(interfaces1Arr));
		Class<?> interfaces1 = interfaces1Arr[0];
		
		
		//构造class2
		Class<?> clazz2 = JarClassManager.getLoadedClass(jclName, className2);
		Object instance2 = clazz2.newInstance();
		//获得实现类的接口
		Class<?>[] interfaces2Arr = clazz2.getInterfaces();
		System.out.println(Arrays.asList(interfaces2Arr));
		Class<?> interfaces2 = interfaces2Arr[0];
		
		
		
		//根据类名获取Class对象  构造class0
		Class<?> clazz0 = JarClassManager.getLoadedClass(jclName, className0);
		//参数类型数组
		Class<?>[] parameterTypes0={interfaces1, interfaces2};
		//根据参数类型获取相应的构造函数
		Constructor<?> constructor=clazz0.getConstructor(parameterTypes0);
		//参数数组
		Object[] parameters={instance1, instance2};
		//根据获取的构造函数和参数，创建实例
		Object instance=constructor.newInstance(parameters);
		System.out.println("---------------");
		
		
		//反射去执行真正的方法
		Method targetMethod = clazz0.getMethod(methodName, parameterTypes);
		targetMethod.invoke(instance, args);
		
		return true;
	}
}

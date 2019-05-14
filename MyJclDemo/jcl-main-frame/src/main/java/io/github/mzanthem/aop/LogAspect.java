/*
 * LogAspect.java Created On 2018年11月28日
 * Copyright(c) 2018 Mazan Inc.
 * ALL Rights Reserved.
 */
package io.github.mzanthem.aop;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.github.mzanthem.core.JarClassManager;

/**
 * LogAspect
 * AOP方案
 * 通过AspectJ 实现静态AOP
 * --> 使用agent动态添加注解拦截,代替AOP
 * @time: 上午10:09:13
 * @author mazan
 */
@Aspect
@Component
public class LogAspect {
	
	private static final String dynamicAop = "io.github.mzanthem.aop.DynamicAspect";
	private static final String dynamicAopMethodName = "execute";
	
	//放到缓存中，页面按钮刷新或者定时任务刷新
	private static Map<String, String> shopMap;
	static {
		shopMap = new HashMap<>();
		shopMap.put("nike", "create-order-nike");
		shopMap.put("adidas", "create-order-adidas");
		shopMap.put("adidas2", "create-order-adidas2");
	}
	
	private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
	
	/**
	 * 切点不会执行
	 */
	@Pointcut("execution(public * io.github.mzanthem.service.MyTestService.*(..))")
	public void webLog() {
		System.out.println("AOP @Pointcut");
	}

	/**
	 *  在真正方法之前执行
	 * @param joinPoint
	 * @throws Throwable
	 */
	@Before("webLog()")
	public void deBefore(JoinPoint joinPoint) throws Throwable {
		System.out.println("AOP @Before Advice...");
		// 接收到请求，记录请求内容
		System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName());
		System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));
	}
	/**
	 * 在真正方法之后
	 */
	@After("webLog()")
	public void doAfter(JoinPoint joinPoint) {
		System.out.println("AOP @After Advice...");
	}

	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret) throws Throwable {
		System.out.println("AOP @AfterReturning Advice...");
		// 处理完请求，返回内容
		logger.info("RESPONSE : " + ret);
	}
	
	
	@AfterThrowing(pointcut="webLog()",throwing="error")
    public void afterThrowing(JoinPoint joinPoint,Throwable error){
        System.out.println("AOP @AfterThrowing Advice..." + error);
        System.out.println("AfterThrowing...");
    }
	
	@Around("webLog()")
    public void around(ProceedingJoinPoint pjp){
        System.out.println("AOP @Around before...");
        
        System.out.println("-------- signature  --------");
        Signature signature = pjp.getSignature();
        //方法名
        String methodName = signature.getName();
        System.out.println("methodName:" + methodName);
        System.out.println("-------- methodSignature --------");
        MethodSignature methodSignature = (MethodSignature)signature;
        //所有参数的类型
        Class<?>[] parameterTypes = methodSignature.getParameterTypes();
		System.out.println("parameterTypes:" + Arrays.asList(parameterTypes));
		//所有参数的名称
        String[] parameterNames = methodSignature.getParameterNames();
		System.out.println("parameterNames:" + Arrays.asList(parameterNames));
        
        //参数
        Object[] args = pjp.getArgs();
        
		Object shopId = args[0];
		System.out.println("-----------try begin--------------");
        try {
        	
        	if (shopMap.containsKey(shopId)) {
        		//加载第三方jarClassLoader
        		String jclName = shopMap.get(shopId);
        		Class<?> clazz = JarClassManager.getLoadedClass(jclName, dynamicAop);
        		Object instance = clazz.newInstance();
        		
        		System.out.println("------------execute------------");
        		//execute(String jclName, String methodName, Class<?>[] parameterTypes, Object[] args)
        		Method theMethod = clazz.getMethod(dynamicAopMethodName, String.class, String.class, Class[].class, Object[].class); //java.lang.NoSuchMethodException: io.github.mzanthem.aop.DynamicAspect.execute(org.aspectj.lang.ProceedingJoinPoint, java.lang.String)
        		Object[] params = {jclName, methodName, parameterTypes, args};
        		boolean ret = (boolean) theMethod.invoke(instance, params);
        		if (!ret) {
        			System.out.println("方法未执行");
        			pjp.proceed();
        		}
        		
        	}else {
        		System.out.println("执行原方法");
        		pjp.proceed();
        	}
        	
        } catch (Throwable e) {
            e.printStackTrace();
            //执行原有逻辑
        }
        System.out.println("-----------try end--------------");
        System.out.println("AOP @Aronud after...");
    }
}

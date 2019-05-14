/*
 * JCLController.java Created On 2018年11月22日
 * Copyright(c) 2018 Mazan Inc.
 * ALL Rights Reserved.
 */
package io.github.mzanthem.controller;

import java.lang.reflect.Method;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xeustechnologies.jcl.exception.JclException;

import io.github.mzanthem.core.JarClassManager;
import io.github.mzanthem.core.JarManager;
import io.github.mzanthem.springmvc.service.EndpointService;
import io.swagger.annotations.ApiOperation;

/**
 * JCLController 1.动态加载一个jar 2.执行jar中的方法 3.卸载jar
 * 
 * 状态持久化到数据库 init 加载
 * 
 * @time: 下午2:40:23
 * @author mazan
 */
@RestController
@RequestMapping("/jcl")
public class JCLController {

	private static final Logger logger = LoggerFactory.getLogger(JCLController.class);
	
	@Autowired
	private EndpointService endpointService;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ApiOperation(value = "spring-boot test", httpMethod = "GET")
	public String test() {
		return "test";
	}

	/**
	 * 默认只能加载一个context
	 * @return
	 */
	@RequestMapping(value = "/addController", method = RequestMethod.GET)
	@ApiOperation(value = "spring-boot test add controller", httpMethod = "GET")
	public String addController() {
		String jclName = "testController";
		String jarFile = "D:\\github\\MyJclDemo\\jcl-test-Controller\\target\\jcl-test-Controller-0.0.1-SNAPSHOT.jar";
		String className = "io.github.mzanthem.controller.TestController";
		Class<?> clazz = null;
		try {
			JarManager.add(jclName, jarFile);
			clazz = JarClassManager.loadClass(jclName, className);
			
			// 实例化
		} catch (Exception e) {
			e.printStackTrace();
			JarClassManager.unloadAllClasses(jclName);
			JarManager.remove(jclName);
		}
		if (clazz == null) {
			return "fail";
		}
		
		Object handler = null;
		Method theMethod = null;
		try {
			handler = clazz.newInstance();
			// 无参方法
			theMethod = clazz.getMethod("test");
			
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		// TODO 自动addMapping,在类加载完毕后，扫描被加载的classT
		try {
			endpointService.addMapping("/testController/test", RequestMethod.GET, handler, theMethod);
		} catch (Exception e) {
			System.out.println("add mapping exception");
			e.printStackTrace();
		}
		
		return "test";
	}
	
	
	/**
	 * 默认只能加载一个context
	 * @return
	 */
	@RequestMapping(value = "/addController2", method = RequestMethod.GET)
	@ApiOperation(value = "spring-boot test add controller", httpMethod = "GET")
	public String addController2() {
		String jclName = "testController";
		String jarFile = "D:\\github\\MyJclDemo\\jcl-test-Controller\\target\\jcl-test-Controller-0.0.1-SNAPSHOT.jar";
		String className = "io.github.mzanthem.controller.TestController";
		Class<?> clazz = null;
		// 再次加载会失败,所以要检查是否已经加载
//		JarManager.
		try {
			JarManager.add(jclName, jarFile);
			clazz = JarClassManager.loadClass(jclName, className);
			
			// 实例化
		} catch (Exception e) {
			e.printStackTrace();
			JarClassManager.unloadAllClasses(jclName);
			JarManager.remove(jclName);
		}
		System.out.println("load a controller");
		if (clazz == null) {
			return "fail";
		}
		
		System.out.println("-------- be instance --------");
		Object handler = null;
		Method theMethod = null;
		try {
			handler = clazz.newInstance();
			
			// 无参方法
			theMethod = clazz.getMethod("test");
			
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		System.out.println("-------- be refresh --------");
		
		try {
			endpointService.addMapping("/testController/test2", RequestMethod.GET, handler, theMethod);
		} catch (Exception e) {
			System.out.println("add mapping exception");
			e.printStackTrace();
		}
		
		return "test";
	}
	/**
	 * _动态添加A-controller
	 * @return
	 */
	@RequestMapping(value = "/onloadNike", method = RequestMethod.GET)
	@ApiOperation(value = "spring-boot test", httpMethod = "GET")
	public String onloadNike() {
		String jarFile = "D:\\workspace\\Test\\create-order-impl-nike\\target\\create-order-impl-nike-jar-with-dependencies.jar";
		String jclName = "create-order-nike";
		
		String className1 = "io.github.mzanthem.service.impl.CreateOrderServiceImpl";
        String className2 = "io.github.mzanthem.service.impl.MyTestServiceImpl";
        String classNameAOP = "io.github.mzanthem.aop.DynamicAspect";
        
		try {
			JarManager.add(jclName, jarFile);
//			JarClassManager.loadAllClasses(jclName);
			JarClassManager.loadClass(jclName, className1);
			JarClassManager.loadClass(jclName, className2);
			JarClassManager.loadClass(jclName, classNameAOP);
			
		} catch (JclException | ClassNotFoundException e) {
			e.printStackTrace();
			return "error";
		}
		try {
			Map<String, Class<?>> listLoadedClass = JarClassManager.listLoadedClass(jclName);
			for(String key : listLoadedClass.keySet()) {
				System.out.println(key);
			}
			
			System.out.println(listLoadedClass.containsKey(className1));
			System.out.println(listLoadedClass.containsKey(className2));
			System.out.println(listLoadedClass.containsKey(classNameAOP));
		} catch (JclException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("");
		
		
		return "success";
	}

	
}

/*
 * LogAspectTest.java Created On 2018年11月28日
 * Copyright(c) 2018 Mazan Inc.
 * ALL Rights Reserved.
 */
package io.github.mzanthem.aop;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.xeustechnologies.jcl.exception.JclException;

import io.github.mzanthem.JclSpringDemoApplicationTests;
import io.github.mzanthem.core.JarClassManager;
import io.github.mzanthem.core.JarManager;
import io.github.mzanthem.service.MyTestService;

/**
 * LogAspectTest
 *
 * @time: 下午6:09:37
 * @author mazan
 */
public class LogAspectAdidasTest extends JclSpringDemoApplicationTests{

	
	@Autowired
	private MyTestService myTestService;
	
	@Before
	public void setUp() throws Exception {
		//加载jar包
		String jarFile = "D:\\github\\MyJclDemo\\jcl-aop-create-order-impl-adidas\\target\\create-order-impl-adidas.jar";
		String jclName = "create-order-adidas";
		
		String className1 = "io.github.mzanthem.service.impl.CreateOrderServiceImpl";
        String className2 = "io.github.mzanthem.service.impl.MyTestServiceImpl";
        String className3 = "io.github.mzanthem.service.impl.AdidasSkuServiceImpl";
        String classNameAOP = "io.github.mzanthem.aop.DynamicAspect";
        
		try {
			JarManager.add(jclName, jarFile);
//			JarClassManager.loadAllClasses(jclName);
			JarClassManager.loadClass(jclName, className1);
			JarClassManager.loadClass(jclName, className2);
			JarClassManager.loadClass(jclName, className3);
			JarClassManager.loadClass(jclName, classNameAOP);
			
		} catch (JclException | ClassNotFoundException e) {
			e.printStackTrace();
			throw e; //java.lang.ClassNotFoundException: io.github.mzanthem.service.AdidasSkuService
		}
		try {
			Map<String, Class<?>> listLoadedClass = JarClassManager.listLoadedClass(jclName);
			for(String key : listLoadedClass.keySet()) {
				System.out.println(key);
			}
			
			System.out.println(listLoadedClass.containsKey(className1));
			System.out.println(listLoadedClass.containsKey(className2));
			System.out.println(listLoadedClass.containsKey(className3));
			System.out.println(listLoadedClass.containsKey(classNameAOP));
		} catch (JclException e) {
			e.printStackTrace();
		}
		System.out.println("");
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void test() {
		System.out.println("----------test------------");
		this.myTestService.createOrder("adidas");
	}
	
}

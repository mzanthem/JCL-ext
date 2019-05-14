/*
 * MyTestTest.java Created On 2018年11月26日
 * Copyright(c) 2018 Mazan Inc.
 * ALL Rights Reserved.
 */
package io.github.mzanthem.mock;

import org.junit.Test;
import org.xeustechnologies.jcl.context.JclContext;
import org.xeustechnologies.jcl.exception.JclException;
import org.xeustechnologies.jcl.test.TestInterface;

import io.github.mzanthem.core.JarClassManager;
import io.github.mzanthem.core.JarManager;
import io.github.mzanthem.test.MyTest;

/**
 * MyTestTest
 * 模拟jar包升级
 * @time: 下午4:02:13
 * @author mazan
 */
public class MyTestTest {

	private static final String jcl_A = "E:\\my-test-service\\test-jcl-A.jar";
	private static final String jcl_B = "E:\\my-test-service\\test-jcl-B.jar";
	
	private static final String jclName_A = "jcl_A";
	private static final String jclName_B = "jcl_B";
	private static final String className = "org.xeustechnologies.jcl.test.TestInterfaceImpl";
	
	@Test
	public void testSayHello() throws ClassNotFoundException, InstantiationException, IllegalAccessException, JclException {
		
		JarManager.add(jclName_A, jcl_A); //有依赖的jar包也要添加进来
		Class<?> classA = JarClassManager.loadClass(jclName_A, className);
		TestInterface testInterfaceA = (TestInterface) classA.newInstance();
		
		MyTest mytest = new MyTest(testInterfaceA);
		System.out.println("mytest:" + mytest);
		mytest.test();
		
		System.out.println("=================================卸载JCL_A");
		
		testInterfaceA = null; //
		classA = null;
		JarClassManager.unloadClass(jclName_A, className);
		JclContext.removeJcl(jclName_A);
		
		System.out.println(JclContext.getAllJclNames());
		System.out.println("=================================");
		
		JarManager.add(jclName_B, jcl_B);
		Class<?> classB = JarClassManager.loadClass(jclName_B, className);
		TestInterface testInterfaceB = (TestInterface) classB.newInstance();
		
		mytest = new MyTest(testInterfaceB);
		System.out.println("mytest:" + mytest);
		mytest.test();
		
	}
	
	@Test
	public void testA() throws ClassNotFoundException, JclException, InstantiationException, IllegalAccessException {
		JarManager.add(jclName_A, jcl_A);
		Class<?> classA = JarClassManager.loadClass(jclName_A, className);
		TestInterface testInterfaceA = (TestInterface) classA.newInstance();
		
		MyTest mytest = new MyTest(testInterfaceA);
		System.out.println("mytest:" + mytest);
		mytest.test();
	}
	
	
	@Test
	public void testB() throws ClassNotFoundException, JclException, InstantiationException, IllegalAccessException {
		JarManager.add(jclName_B, jcl_B);
		Class<?> classB = JarClassManager.loadClass(jclName_B, className);
		TestInterface testInterfaceB = (TestInterface) classB.newInstance();
		
		MyTest mytest = new MyTest(testInterfaceB);
		System.out.println("mytest:" + mytest);
		mytest.test();
	}

}

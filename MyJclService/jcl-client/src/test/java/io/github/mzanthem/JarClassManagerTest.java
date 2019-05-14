/*
 * JarClassTest.java Created On 2018年11月23日
 * Copyright(c) 2018 Mazan Inc.
 * ALL Rights Reserved.
 */
package io.github.mzanthem;

import static org.junit.Assert.fail;

import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.xeustechnologies.jcl.JarClassLoader;
import org.xeustechnologies.jcl.context.JclContext;
import org.xeustechnologies.jcl.exception.JclException;

import io.github.mzanthem.core.JarClassManager;
import io.github.mzanthem.core.JarManager;


/**
 * JarClassTest
 *
 * @time: 下午3:20:33
 * @author mazan
 */
public class JarClassManagerTest {
	private static final String jcl = "jcl";
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void loadAllClassTest() throws ClassNotFoundException, JclException {
		String jarFile = "E:\\task-api-2.1.6.jar";
		String jclName = "task-api-2.1.6";
		String className = "io.github.mzanthem.baseservice.task.util.DateUtil";
		
		JarManager.add(jclName, jarFile);
		
		try {
			System.out.println("--------0");
			JarClassManager.loadAllClasses(jclName);
			fail("needed ext jars!");
		} catch (NoClassDefFoundError e) {
			System.out.println("-------1");
		}
		
		String jarFile2 = "E:\\lark-common-1.0.3.jar";
		JarManager.add(jclName, jarFile2);
		
		try {
			JarClassManager.loadAllClasses(jclName);
			fail("needed ext jars!");
		} catch (NoClassDefFoundError e) {
			System.out.println("-------2");
//			throw e; //如果不throw，则会继续执行
		}
		System.out.println("--------只加载了部分代码");
		
		Map<String, Class<?>> map = JarClassManager.listLoadedClass(jclName);
		for (Map.Entry<String, Class<?>> entry : map.entrySet()) {
			System.out.println(entry.getKey());
		}
		System.out.println("=================================");
		//实例化
		System.out.println(map.containsKey(className));
		
	}
	
	@Test
	public void getJarClassTest() {
		String jarFile = "E:\\task-api-2.1.6.jar";
		String jclName = "task-api-2.1.6";
		JarManager.add(jclName, jarFile);
		
		JarClassLoader jcl = JclContext.get(jclName);
		System.out.println(jcl);
		
		Set<String> keySet = jcl.getLoadedResources().keySet();
		for (String string : keySet) {
			System.out.println(string);
		}
		
	}
	/**
	 * 加载一个class
	 * @throws MyJclException 
	 */
	@Test
	public void loadClassTest() throws JclException {
		String jarFile = "E:\\task-api-2.1.6.jar";
		String className = "io.github.mzanthem.baseservice.task.util.DateUtil";
		try {
			JarManager.add(jcl, jarFile);
			Class<?> clazz = JarClassManager.loadClass(jcl, className);
			System.out.println(clazz.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(JarClassManager.listLoadedClass(jcl));
	}
	
	/**
	 * 加载一个class
	 * @throws MyJclException 
	 */
	@SuppressWarnings("unused")
	@Test
	public void loadClass2Test() throws JclException {
		String jarFile = "E:\\task-api-2.1.6.jar";
		String className = "io.github.mzanthem.baseservice.task.util.DateUtil";
		String className2 = "io.github.mzanthem.baseservice.task.util.TaskMessageUtil";
		try {
			JarManager.add(jcl, jarFile);
			Class<?>[] clazzes = JarClassManager.loadClass(jcl, className, className2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(JarClassManager.listLoadedClass(jcl));
	}
	/**
	 * 加载一个class
	 * @throws MyJclException 
	 */
	@Test
	public void loadClassTest2() throws JclException {
		String jarFile = "E:\\task-api-2.1.6.jar";
		String jarFileExt = "E:\\lark-common-1.0.3.jar";
		String className = "io.github.mzanthem.baseservice.task.model.log.TaskLog";
		try {
			JarManager.add(jcl, jarFileExt);
			JarManager.add(jcl, jarFile);
			Class<?> clazz = JarClassManager.loadClass(jcl, className);
			System.out.println(clazz.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(JarClassManager.listLoadedClass(jcl));
	}
	
	
	@Test
	public void unloadClassTest() throws JclException {
		String jarFile = "E:\\task-api-2.1.6.jar";
		String className = "io.github.mzanthem.baseservice.task.util.DateUtil";
		try {
			JarManager.add(jcl, jarFile);
			Class<?> clazz = JarClassManager.loadClass(jcl, className);
			System.out.println(clazz.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(JarClassManager.listLoadedClass(jcl));
		
		//unload
		JarClassManager.unloadClass(jcl, className);
		System.out.println(JarClassManager.listLoadedClass(jcl));
		
		
	}
}

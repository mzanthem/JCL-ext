/*
 * LoggerTest.java Created On 2018年11月30日
 * Copyright(c) 2018 Mazan Inc.
 * ALL Rights Reserved.
 */
package io.github.mzanthem;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xeustechnologies.jcl.exception.JclException;

import io.github.mzanthem.core.JarClassManager;
import io.github.mzanthem.core.JarManager;

/**
 * LoggerTest
 *
 * @time: 上午10:57:47
 * @author mazan
 */
public class LoggerTest {

	private static Logger logger = LoggerFactory.getLogger(LoggerTest.class);
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		logger.debug("jcl-spring-demo");
		logger.info("jcl-spring-demo");
		logger.warn("jcl-spring-demo");
		logger.error("jcl-spring-demo");
	}
	
	
	@Test
	public void testJcl() throws ClassNotFoundException, JclException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		String jarFile = "E:\\task-api-2.1.6.jar";
		String jarFile2 = "E:\\Repository\\org\\quartz-scheduler\\quartz\\2.2.2\\quartz-2.2.2.jar";
		
		String jclName = "task-api-2.1.6";
		String className = "io.github.mzanthem.baseservice.task.util.TaskTimeCronExpUtil";
		
		JarManager.add(jclName, jarFile);
		JarManager.add(jclName, jarFile2);
		Class<?> clazz = JarClassManager.loadClass(jclName, className);
		
		Object instance = clazz.newInstance();
		
		Method m = clazz.getMethod("checkTimeExp", String.class);
		System.out.println("----------------------");
		String cronExp="0 0/2 * * * ?";
		Object invoke = m.invoke(instance, cronExp);
		System.out.println(invoke);
		
	}

}

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

import io.github.mzanthem.core.JarClassManager;
import io.github.mzanthem.core.JarManager;

/**
 * LoggerTest
 *
 * @time: 上午10:34:14
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
		logger.debug("nike");
		logger.info("nike");
		logger.warn("nike");
		logger.error("nike");
		
	}

}

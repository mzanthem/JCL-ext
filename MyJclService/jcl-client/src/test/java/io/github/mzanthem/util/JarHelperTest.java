/*
 * JarHelperTest.java Created On 2019年4月16日
 * Copyright(c) 2019 Mazan.
 * ALL Rights Reserved.
 */
package io.github.mzanthem.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JarHelperTest
 *
 * @time: 上午11:20:44
 * @author mazan
 */

public class JarHelperTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_is() {
		assertTrue(JarHelper.isJar("a.jar"));
		assertFalse(JarHelper.isJar("a.jax"));
		assertTrue(JarHelper.isClass("JarHelper.class"));
		assertFalse(JarHelper.isClass("JarHelper.classes"));
	}

}

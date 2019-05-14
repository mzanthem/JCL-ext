/*
 * ParameterTypesTest.java Created On 2018年11月29日
 * Copyright(c) 2018 Mazan Inc.
 * ALL Rights Reserved.
 */
package io.github.mzanthem.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * ParameterTypesTest
 *
 * @time: 下午2:56:27
 * @author mazan
 */
public class ParameterTypesTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		System.out.println("---------------------------");
		Object arg = "aaa";
		System.out.println(arg.getClass());
		
		System.out.println("---------------------------");
		Object[] args = {"aaa", "bbb"};
		System.out.println(args.getClass());
		

		
		System.out.println("---------------------------");
		System.out.println(Object[].class);
		
		System.out.println("---------------------------");
		Class<?>[] parameterTypes = {String.class, Integer.class};
		System.out.println(parameterTypes.getClass());
		System.out.println(Class[].class);
	}

}

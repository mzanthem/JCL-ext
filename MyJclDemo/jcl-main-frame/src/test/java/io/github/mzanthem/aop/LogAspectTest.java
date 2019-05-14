/*
 * LogAspectTest.java Created On 2018年11月28日
 * Copyright(c) 2018 Mazan Inc.
 * ALL Rights Reserved.
 */
package io.github.mzanthem.aop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import io.github.mzanthem.JclSpringDemoApplicationTests;
import io.github.mzanthem.service.MyTestService;

/**
 * LogAspectTest
 *
 * @time: 下午6:09:37
 * @author mazan
 */
public class LogAspectTest extends JclSpringDemoApplicationTests{

	
	@Autowired
	private MyTestService myTestService;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void test() {
		this.myTestService.createOrder("UGG");
	}
	
}

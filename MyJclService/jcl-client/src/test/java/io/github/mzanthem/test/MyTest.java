/*
 * MyTest.java Created On 2018年11月26日
 * Copyright(c) 2018 Mazan Inc.
 * ALL Rights Reserved.
 */
package io.github.mzanthem.test;

import org.xeustechnologies.jcl.test.TestInterface;

/**
 * MyTest
 * 非spring
 * 动态绑定testInterface
 * @time: 下午3:38:04
 * @author mazan
 */
public class MyTest {

	private TestInterface testInterface;
	
	public MyTest(TestInterface testInterface) {
		this.testInterface = testInterface;
	}
	
	public void test() {
		String r = this.testInterface.sayHello();
		System.out.println(r);
	}
	
}

/*
 * FileUtilTest.java Created On 2019年4月16日
 * Copyright(c) 2019 Mazan.
 * ALL Rights Reserved.
 */
package io.github.mzanthem.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * FileUtilTest
 *
 * @time: 上午11:15:12
 * @author mazan
 */

public class FileUtilTest {

	String path = "./target";
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		List<String> list = new ArrayList<>();
		try {
			 list = FileUtils.findAllJars(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(list);
	}

}

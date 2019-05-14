/*
 * URLTest.java Created On 2018年11月27日
 * Copyright(c) 2018 Mazan Inc.
 * ALL Rights Reserved.
 */
package io.github.mzanthem;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.mzanthem.util.FileUtils;

/**
 * URLTest
 *
 * @time: 上午10:53:35
 * @author mazan
 */
public class URLTest {

	private static Logger logger = LoggerFactory.getLogger(URLTest.class);
	
	@Test
	public void test() throws MalformedURLException {
		String filePath = "E:\\share\\task-api-2.1.6.jar";
		File file = new File(filePath);
		System.out.println(file.toURI().toURL());
	}

	
	@Test
	public void testFolder() throws IOException {
		String folder = "E:\\share\\";
		List<String> files = FileUtils.findAllJars(folder);
		System.out.println("============================");
		for (String fileName : files) {
			System.out.println(fileName);
			System.out.println(folder + File.separatorChar + fileName);
		}
	}
	
	
	@Test
	public void testLog() {
		logger.debug("aaa");
		logger.info("aaa");
		logger.warn("aaa");
		logger.error("aaa");
	}
}

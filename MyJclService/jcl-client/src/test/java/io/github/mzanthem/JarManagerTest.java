/*
 * JarLoadFromFolderTest.java Created On 2018年11月23日
 * Copyright(c) 2018 Mazan Inc.
 * ALL Rights Reserved.
 */
package io.github.mzanthem;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.xeustechnologies.jcl.JarClassLoader;
import org.xeustechnologies.jcl.context.JclContext;
import org.xeustechnologies.jcl.exception.JclException;

import io.github.mzanthem.core.JarManager;
import io.github.mzanthem.util.FileUtils;

/**
 * JarLoadFromFolderTest 模拟从文件夹加载jar包
 * 
 * @time: 下午2:45:19
 * @author mazan
 */
public class JarManagerTest {

	private static final String sharedFolder = "E:\\share"; // 公共目录
	private static final String jcl = "jcl";

	/**
	 * 从文件夹加载
	 */
	@Test
	public void loadJarByFolderTest() {
		try {
			JarManager.addFolder(jcl, "E://abcdefghijklmnopqrstuvwxyz");
			fail("folder not exist");
		} catch (Exception e) {
		}

		try {
			JarManager.addFolder(jcl, sharedFolder);
		} catch (IOException e) {
			fail("[" + sharedFolder + " ]folder not exist");
		}
		System.out.println(JclContext.getAllJclNames());
	}

	/**
	 * 每一个jar均分配一个JCL
	 */
	@Test
	public void loadJarByFolderEachTest() {
		try {
			JarManager.addFolder(jcl, "E://abcdefghijklmnopqrstuvwxyz");
			fail("folder not exist");
		} catch (Exception e) {
		}

		try {
			JarManager.addFolder(jcl, sharedFolder);
		} catch (IOException e) {
			fail("[" + sharedFolder + " ]folder not exist");
		}
		System.out.println(JclContext.getAllJclNames());
	}

	/**
	 * 自定义分组： 一组jar 分配一个JCL
	 */
	@Test
	public void loadJarByFolderGroupTest() {

		// 加载所有共享目录下的jar包
		System.out.println("-------- load jars as group from [sharedFolder]......");

		try {
			List<String> files = FileUtils.findAllJars(sharedFolder);
			Map<String, List<File>> group = new HashMap<String, List<File>>();

			for (String fileName : files) {
				String fullPath = sharedFolder + File.separatorChar + fileName;
				File file = new File(fullPath);
				if (fileName.startsWith("task-")) {
					put("task", file, group);
				} else if (fileName.startsWith("my-test-service-")) {
					put("my-test-service", file, group);
				} else {
					put("other", file, group);
				}
			}

			// 分组加载
			JarClassLoader jarClassLoader = null;
			for (Map.Entry<String, List<File>> entry : group.entrySet()) {
				jarClassLoader = new JarClassLoader();

				String key = entry.getKey();
				List<File> value = entry.getValue();
				System.out.println("-------------");
				System.out.println("key:" + key);
				for (File file : value) {
					System.out.println(file.getName());
					jarClassLoader.add(file.toURI().toURL());
				}
				JclContext jclContext = JclContext.getInstance();
				jclContext.addJcl(key, jarClassLoader);
			}

		} catch (IOException e) {
		}
		System.out.println("-------------");
		System.out.println(JclContext.getAllJclNames());
	}

	@Test
	public void loadJarByAll() throws IOException, JclException {
		// 加载所有共享目录下的jar包
		System.out.println("-------- load jars as group from [sharedFolder]......");

		List<String> files = FileUtils.findAllJars(sharedFolder);
		Map<String, List<File>> group = new HashMap<String, List<File>>();

		for (String fileName : files) {
			String fullPath = sharedFolder + File.separatorChar + fileName;
			File file = new File(fullPath);
			if (fileName.startsWith("task-")) {
				put("task", file, group);
			} else if (fileName.startsWith("my-test-service-")) {
				put("my-test-service", file, group);
			} else {
				put("other", file, group);
			}
		}
		
		for (Map.Entry<String, List<File>> entry : group.entrySet()) {
			String key = entry.getKey();
			List<File> value = entry.getValue();
			
			File[] fileArr = new File[value.size()];
			value.toArray(fileArr);
			
			JarManager.addAll(key, fileArr);
		}
		
		System.out.println(JclContext.getAllJclNames());
		
		System.out.println("----------------------");
		System.out.println(JarManager.getLoadedResources("task"));
	}

	private static void put(String key, File file, Map<String, List<File>> group) {
		List<File> value = group.get(key);
		if (value == null) {
			value = new LinkedList<File>();
		}
		value.add(file);
		group.put(key, value);
	}

	@Test
	public void getLoadedResourcesTest() throws IOException, JclException {
		// JarManager.add(new File("E:\\task-api-2.1.6.jar"));
		// JarManager.add(new File("E:\\task-api-2.1.6.jar"));

		JarManager.addFolder(jcl, sharedFolder);
		System.out.println(JclContext.get());

		List<String> list = JarManager.getLoadedResources(jcl);
		System.out.println(list.size());

		for (String string : list) {
			System.out.println(string);
		}
	}

	@Test
	public void getLoadedResourcesTest2() throws JclException {
		String jclName = "task-api-2.1.6";
		JarManager.add(jclName, new File("E:\\task-api-2.1.6.jar"));
		System.out.println(JclContext.get(jclName));

		List<String> list = JarManager.getLoadedResources(jclName);
		for (String string : list) {
			System.out.println(string);
		}
	}
}

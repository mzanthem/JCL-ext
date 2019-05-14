/*
 * JarManager.java Created On 2018年11月23日
 * Copyright(c) 2018 Mazan Inc.
 * ALL Rights Reserved.
 */
package io.github.mzanthem.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.xeustechnologies.jcl.JarClassLoader;
import org.xeustechnologies.jcl.context.JclContext;
import org.xeustechnologies.jcl.exception.JclException;

import io.github.mzanthem.util.FileUtils;
import io.github.mzanthem.util.JarHelper;

/**
 * JarManager jar包的管理入口
 * 
 * @time: 上午11:21:54
 * @author mazan
 */
public class JarManager {

	/**
	 * @param folder
	 * @throws IOException
	 */
	public static void addFolder(String jclName, String folder) throws IOException {
		JarHelper.assertString(folder);
		JarHelper.assertString(jclName);
		
		JarClassLoader jarClassLoader = JarHelper.getJarClassLoader(jclName);
		
		List<String> files = FileUtils.findAllJars(folder);
		for (String fileName : files) {
			String fullPath = folder + File.separatorChar + fileName;
			jarClassLoader.add(fullPath);
		}
		
	}

	
	
	/**
	 * 添加到隔离的JCL
	 * @param jclName
	 * @param url
	 */
	public static void add(String jclName, URL url) {
		JarHelper.assertString(jclName);
		
		JarClassLoader jarClassLoader = JarHelper.getJarClassLoader(jclName);
		jarClassLoader.add(url);
	}



	/**
	 * 添加到隔离的JCL
	 * @param jarFilePath
	 * @param jclName
	 */
	public static void add(String jclName, String jarFilePath) {
		add(jclName, new File(jarFilePath));
	}

	/**
	 * 添加到隔离的JCL
	 * @param jarFile
	 * @param jclName
	 */
	public static void add(String jclName, File jarFile) {

		JarHelper.assertString(jclName);
		
		String fileName = jarFile.getName();
		JarHelper.assertJarName(fileName);
		
		try {
			add(jclName, new FileInputStream(jarFile));
		} catch (FileNotFoundException e) {
			throw new JclException("jar load failed cause FileNotFoundException", e);
		}
		
	}

	/**
	 * 添加到隔离的JCL
	 * @param inputStream
	 * @param jclName
	 */
	private static void add(String jclName, InputStream inputStream) {
		
		JarClassLoader jarClassLoader = JarHelper.getJarClassLoader(jclName);
		jarClassLoader.add(inputStream);
		
	}
	
	/**
	 * 添加多个jar包
	 * @param jclName
	 * @param url
	 */
	public static void addAll(String jclName, URL... url) {
		JarHelper.assertString(jclName);
		
		JarClassLoader jarClassLoader = JarHelper.getJarClassLoader(jclName);
		jarClassLoader.addAll(url);
	}



	/**
	 * 添加多个jar包
	 * @param jclName
	 * @param filePath
	 */
	public static void addAll(String jclName, String... filePath) {
		JarHelper.assertString(jclName);
		
		JarClassLoader jarClassLoader = JarHelper.getJarClassLoader(jclName);
		jarClassLoader.addAll(filePath);
	}
	/**
	 * 添加多个jar包
	 * @param jclName
	 * @param file
	 * @throws FileNotFoundException 
	 */
	public static void addAll(String jclName, File... file){
		JarHelper.assertString(jclName);
		
		JarClassLoader jarClassLoader = JarHelper.getJarClassLoader(jclName);
		try {
			for (File jarFile : file) {
				jarClassLoader.add(new FileInputStream(jarFile));
			}
		} catch (FileNotFoundException e) {
			throw new JclException("jar load failed cause FileNotFoundException", e);
		}
	}
	
	/**
	 * 获得JCL加载的Class
	 * @param jclName
	 * @return
	 * @throws MyJclException 
	 */
	public static List<String> getLoadedResources(String jclName) throws JclException {
		JarClassLoader jarClassLoader = JarHelper.getJarClassLoaderChecked(jclName); //JclName验证
		return getLoadedResources(jarClassLoader);
	}
	/**
	 * 获得JCL加载的Class
	 * @param jarClassLoader
	 * @return
	 */
	public static List<String> getLoadedResources(JarClassLoader jarClassLoader) {
		List<String> list = new ArrayList<String>();
		Set<String> resourceSet = jarClassLoader.getLoadedResources().keySet();
		for (String resource : resourceSet) {
			if (JarHelper.isClass(resource)) {
				list.add(JarHelper.handlerClassName(resource));
			}
		}
		return list;
	}
	
	/**
	 * 卸载一个Jar
	 * @param jclName
	 * @throws MyJclException 
	 */
	public static void remove(String jclName) throws JclException {
		//卸载所有实例
		
		//卸载所有加载的class
		JarClassManager.unloadAllClasses(jclName);
		//卸载JCL
		JclContext.removeJcl(jclName);
	}
	
}

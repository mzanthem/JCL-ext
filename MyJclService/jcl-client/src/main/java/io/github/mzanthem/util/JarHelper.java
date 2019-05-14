/*
 * JarHelper.java Created On 2018年11月23日
 * Copyright(c) 2018 Mazan Inc.
 * ALL Rights Reserved.
 */
package io.github.mzanthem.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.xeustechnologies.jcl.JarClassLoader;
import org.xeustechnologies.jcl.context.JclContext;
import org.xeustechnologies.jcl.exception.JclContextException;
import org.xeustechnologies.jcl.exception.JclException;

import io.github.mzanthem.constant.JarConstants;

/**
 * JarHelper
 *
 * @time: 下午4:57:07
 * @author mazan
 */
public class JarHelper {

	private JarHelper() {
	}
	
	public static boolean isJar(String name) {
		if (name.endsWith(JarConstants.jarExt)) {
			return true;
		}
		return false;
	}

	public static boolean isClass(String name) {
		if (name.endsWith(JarConstants.classExt)) {
			return true;
		}
		return false;
	}

	public static void assertString(String string) {
		if (StringUtils.isBlank(string)) {
			throw new JclException("required string is blank");
		}
	}

	public static void assertJarName(String name) {
		if (!isJar(name)) {
			throw new JclException("file[" + name +"] not jar");
		}
	}

	public static void assertClassName(String name) {
		if (!isClass(name)) {
			throw new JclException("file[" + name +"] not class");
		}
	}

	/**
	 * 获取指定的JCL
	 * @param jarClassLoaderName
	 * @return
	 * @throws MyJclException 
	 */
	public static JarClassLoader getJarClassLoaderChecked(String jarClassLoaderName) throws JclException {
		JarClassLoader jarClassLoader = JclContext.get(jarClassLoaderName);
		if (null == jarClassLoader) {
			throw new JclException("JarClassLoader[" + jarClassLoaderName + "] not found");
		}
		return jarClassLoader;
	}
	
	/**
	 * 获取指定的JCL
	 * @param jarClassLoaderName
	 * @return
	 */
	public static JarClassLoader getJarClassLoader(String jarClassLoaderName) {
		JclContext jclContext = JclContext.getInstance();
		
		JarClassLoader jarClassLoader = JclContext.get(jarClassLoaderName);
		if (null == jarClassLoader) {
			jarClassLoader = new JarClassLoader();
			jclContext.addJcl(jarClassLoaderName, jarClassLoader);
		}
		return jarClassLoader;
	}
	

	/**
	 * 列举出jar包中的所有class
	 * 
	 * @param jarFile
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static List<String> listClasses(File file) throws IOException {
		JarHelper.assertJarName(file.getName());

		List<String> list = new ArrayList<String>();
		JarFile jarFile = new JarFile(file);
		Enumeration<JarEntry> enu = jarFile.entries();
		while (enu.hasMoreElements()) {
			JarEntry jarEntry = (JarEntry) enu.nextElement();
			String name = jarEntry.getName();
			if (JarHelper.isClass(name)) {
				list.add(name);
			}
		}
		return list;
	}

	/**
	 * 列出jar包中所有的package.class
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static List<String> listPackageClass(File file) throws IOException {
		JarHelper.assertJarName(file.getName());

		List<String> list = new ArrayList<String>();
		JarFile jarFile = new JarFile(file);
		Enumeration<JarEntry> enu = jarFile.entries();
		while (enu.hasMoreElements()) {
			JarEntry jarEntry = (JarEntry) enu.nextElement();
			String name = jarEntry.getName();
			if (JarHelper.isClass(name)) {
				list.add(handlerClassName(name));
			}
		}
		return list;
	}
	/**
	 *io/github/mzanthem/baseservice/task/util/DateUtil.class
	 *io.github.mzanthem.baseservice.task.util.DateUtil
	 * 替换"/"为"."
	 * @param className
	 * @return
	 */
	public static String handlerClassName(String className) {
		String packagename = className.replaceAll("\\/", "\\.");
		int length = packagename.length();
		return packagename.substring(0, length - 6);
	}
}

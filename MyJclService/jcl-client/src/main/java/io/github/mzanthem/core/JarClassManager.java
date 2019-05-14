/*
 * JarClassManager.java Created On 2018年11月23日
 * Copyright(c) 2018 Mazan Inc.
 * ALL Rights Reserved.
 */
package io.github.mzanthem.core;

import java.util.List;
import java.util.Map;

import org.xeustechnologies.jcl.JarClassLoader;
import org.xeustechnologies.jcl.exception.JclException;

import io.github.mzanthem.util.JarHelper;

/**
 * JarClassManager
 * jar包中类的管理
 * 实例化后回调接口
 * @time: 上午11:22:38
 * @author mazan
 */
public class JarClassManager {
	
	/**
	 * 加载jar包中所有class
	 * @param jarClassLoaderName
	 * @return
	 * 
	 * @throws ClassNotFoundException 需要被依赖的jar包
	 * @throws MyJclException 
	 */
	public static void loadAllClasses(String jarClassLoaderName) throws  ClassNotFoundException, JclException {
		JarClassLoader jarClassLoader = JarHelper.getJarClassLoaderChecked(jarClassLoaderName);
		
		List<String> classes = JarManager.getLoadedResources(jarClassLoader);
		for (String className : classes) {
			loadClass(jarClassLoaderName, className);
		}
	}
	
	/**
	 * 卸载已加载的classes
	 * @param jarClassLoaderName
	 * @throws MyJclException
	 */
	public static void unloadAllClasses(String jarClassLoaderName) throws JclException {
		Map<String, Class<?>> classes = listLoadedClass(jarClassLoaderName);
		for (String className : classes.keySet()) {
			unloadClass(jarClassLoaderName, className);
		}
	}
	
	/**
	 * 加载一个类
	 *
	 * @param jarClassLoaderName
	 * @param className
	 *  
	 * @return Clazz
	 * @throws ClassNotFoundException 
	 * @throws MyJclException 
	 */
	public static Class<?> loadClass(String jarClassLoaderName, String className) throws ClassNotFoundException, JclException {
		JarClassLoader jarClassLoader = JarHelper.getJarClassLoaderChecked(jarClassLoaderName);
		return jarClassLoader.loadClass(className);
	}
	
	/**
	 * 加载一个类
	 *
	 * @param jarClassLoaderName
	 * @param className
	 *  
	 * @return Clazz
	 * @throws ClassNotFoundException 
	 * @throws MyJclException 
	 */
	public static Class<?>[] loadClass(String jarClassLoaderName, String... className) throws ClassNotFoundException, JclException {
		JarClassLoader jarClassLoader = JarHelper.getJarClassLoaderChecked(jarClassLoaderName);
		Class<?>[] classes = new Class<?>[className.length];
		for (int i = 0; i < className.length; i++) {
			classes[i] = jarClassLoader.loadClass(className[i]);
		}
		return classes;
	}

	/**
	 * 卸载一个类
	 * @param className
	 * @param jarClassLoaderName
	 * @throws MyJclException 
	 */
	public static void unloadClass(String jarClassLoaderName, String className) throws JclException {
		JarClassLoader jarClassLoader = JarHelper.getJarClassLoaderChecked(jarClassLoaderName);
		jarClassLoader.unloadClass(className);
	}

	/**
	 * 列举出所有加载的class
	 * @return
	 * @throws MyJclException 
	 */
	public static Map<String, Class<?>> listLoadedClass(String jarClassLoaderName) throws JclException {
		JarClassLoader jarClassLoader = JarHelper.getJarClassLoaderChecked(jarClassLoaderName);
		return jarClassLoader.getLoadedClasses();
	}

	/**
	 * 从加载的类中, 获得自己想要的类
	 * @param jarClassLoaderName
	 * @param className
	 * @return
	 * @throws MyJclException 
	 */
	@SuppressWarnings("rawtypes")
	public static Class getLoadedClass(String jarClassLoaderName, String className) throws JclException {
		JarHelper.assertString(className);
		
		Map<String, Class<?>> map = listLoadedClass(jarClassLoaderName);
		if (!map.containsKey(className)) {
			throw new JclException("className[" + className + "]not found in JarClassLoader[" + jarClassLoaderName + "]");
		}
		return map.get(className);
	}
	
}

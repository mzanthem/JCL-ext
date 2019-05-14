/*
 * JarHelperTest.java Created On 2018年11月23日
 * Copyright(c) 2018 Mazan Inc.
 * ALL Rights Reserved.
 */
package io.github.mzanthem;
/**
 * JarHelperTest
 *
 * @time: 下午5:41:16
 * @author mazan
 */

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import io.github.mzanthem.util.JarHelper;

public class JarHelperTest {

	
	@Test
	public void test(){
		String a = "";
		String b = null;
		System.out.println(a.equals(b));
	}
	
	@Test
	public void testListClass() {
		String jarFile = "E:\\task-api-2.1.6.jar";
		List<String> list = null;
		try {
			list= JarHelper.listClasses(new File(jarFile));
		} catch (IOException e) {
		}
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	/**
	 * 输出类列表--符合package.T的形式
	 */
	@Test
	public void testListClassPackage() {
		String jarFile = "E:\\task-api-2.1.6.jar";
		List<String> list = null;
		try {
			list= JarHelper.listPackageClass(new File(jarFile));
		} catch (IOException e) {
		}
		for (String string : list) {
			System.out.println(string);
		}
		
		
	}
}

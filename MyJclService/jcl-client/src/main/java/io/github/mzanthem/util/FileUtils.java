/*
 * FileUtils.java Created On 2018年11月22日
 * Copyright(c) 2018 Mazan Inc.
 * ALL Rights Reserved.
 */
package io.github.mzanthem.util;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import io.github.mzanthem.constant.JarConstants;

/**
 * FileUtils
 *
 * @time: 下午6:31:41
 * @author mazan
 */
public class FileUtils {
	@SuppressWarnings("unused")
	private static final String CLASSPATH_SEPARATOR = File.pathSeparator;
	private static final String OS_NAME = System.getProperty("os.name");// $NON-NLS-1$
	private static final String OS_NAME_LC = OS_NAME.toLowerCase(java.util.Locale.ENGLISH);

	private FileUtils() {
	}

	/**
	 * 查找目录下的所有文件
	 * 
	 * @param folder  文件夹
	 * @return
	 * @throws IOException
	 */
	public static List<String> findAllJars(String folder) throws IOException {
		
		if (StringUtils.isEmpty(folder)) {
			throw new IOException("file path is empty");
		}

		File f = new File(folder);
		if (!f.isDirectory()) {
			throw new IOException("file path is not directory");
		}
		
		List<String> files = new LinkedList<String>(); //fileName list
		/*
		 * Does the system support UNC paths? If so, may need to fix them up
		 * later
		 */
		boolean usesUNC = OS_NAME_LC.startsWith("windows");// $NON-NLS-1$
		// 过滤文件名
//		String[] fileDirs = f.list((FilenameFilter) (dir, name) -> name.endsWith(".jar"));
		String[] fileDirs;
		fileDirs = f.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(JarConstants.jarExt);
			}
		});
		
		for (String s : fileDirs) {
//			System.out.println(s);
			// Fix path to allow the use of UNC URLs
			if (usesUNC) {
				if (s.startsWith("\\\\") && !s.startsWith("\\\\\\")) {// $NON-NLS-1$
					s = "\\\\" + s;// $NON-NLS-1$
				} else if (s.startsWith("//") && !s.startsWith("///")) {// $NON-NLS-1$
					s = "//" + s;// $NON-NLS-1$
				}
			} // usesUNC
			files.add(s);
		}
		return files;
	}

	/**
	 * 把文件复制到目录下
	 * @param file
	 * @param targetFolder
	 */
	public static void copy(File file, String targetFolder) {
		
	}
	/**
	 * 把文件复制到目录下，并重命名
	 * @param file
	 * @param targetFolder
	 * @param targetName 
	 */
	public static void copy(File file, String targetFolder, String targetName) {
		
	}
	

}

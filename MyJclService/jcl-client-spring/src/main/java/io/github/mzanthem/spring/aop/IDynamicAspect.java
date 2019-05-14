/*
 * IDynamicAOP.java Created On 2018年11月30日
 * Copyright(c) 2018 Mazan Inc.
 * ALL Rights Reserved.
 */
package io.github.mzanthem.spring.aop;
/**
 * IDynamicAOP
 *
 * @time: 下午2:27:43
 * @author mazan
 */
public interface IDynamicAspect {

	/**
	 * 具体业务逻辑方法
	 * @param jclName
	 * @param methodName
	 * @param parameterTypes
	 * @param args
	 * @return 是否执行
	 * @throws Exception
	 */
	public boolean execute(String jclName, String methodName, Class<?>[] parameterTypes, Object[] args) throws Exception;
}

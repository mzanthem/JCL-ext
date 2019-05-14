/*
 * CreateStockServiceImpl.java Created On 2018年11月30日
 * Copyright(c) 2018 Mazan Inc.
 * ALL Rights Reserved.
 */
package io.github.mzanthem.service.impl;

import org.springframework.stereotype.Service;

import io.github.mzanthem.service.CreateStockService;

/**
 * CreateStockServiceImpl
 *
 * @time: 上午11:18:33
 * @author mazan
 */
@Service("createStockService")
public class CreateStockServiceImpl implements CreateStockService {
	
	/**
	 * default stock service
	 */
	@Override
	public void createStock(String shopId) {
		System.out.println("default create stock :" + shopId);
	}

}

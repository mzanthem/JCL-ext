/*
 * AdidasSkuServiceImpl.java Created On 2018年11月28日
 * Copyright(c) 2018 Mazan Inc.
 * ALL Rights Reserved.
 */
package io.github.mzanthem.service.impl;

import org.springframework.stereotype.Service;

import io.github.mzanthem.service.AdidasSkuService;

/**
 * AdidasSkuServiceImpl
 *
 * @time: 下午5:55:53
 * @author mazan
 */
@Service("adidasSkuService")
public class AdidasSkuServiceImpl implements AdidasSkuService {

	/**
	 * checkSku
	 */
	@Override
	public void checkSku() {
		System.out.println("adidas check sku");
	}

}

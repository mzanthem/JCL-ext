/*
 * CreateOrderServiceImpl.java Created On 2018年11月28日
 * Copyright(c) 2018 Mazan Inc.
 * ALL Rights Reserved.
 */
package io.github.mzanthem.service.impl;

import org.springframework.stereotype.Service;

import io.github.mzanthem.service.CreateOrderService;

/**
 * CreateOrderServiceImpl
 *
 * @time: 下午2:39:46
 * @author mazan
 */
@Service("createOrderService")
public class CreateOrderServiceImpl implements CreateOrderService {

	/**
	 * 创建订单
	 */
	@Override
	public void createOrder(String shopId) {
		System.out.println("adidas2 create order:" + shopId);
	}

	@Override
	public void createSku(String shopId) {
		System.out.println("adidas2 create sku:" + shopId);
	}

}

/*
 * MyTestServiceImpl.java Created On 2018年11月28日
 * Copyright(c) 2018 Mazan Inc.
 * ALL Rights Reserved.
 */
package io.github.mzanthem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.mzanthem.service.CreateOrderService;
import io.github.mzanthem.service.CreateSkuService;
import io.github.mzanthem.service.CreateStockService;
import io.github.mzanthem.service.MyTestService;

/**
 * MyTestServiceImpl
 *
 * @time: 下午2:36:48
 * @author mazan
 */
@Service("myTestService")
public class MyTestServiceImpl implements MyTestService {

	@Autowired
	private CreateOrderService createOrderService;
	
	@Autowired
	private CreateSkuService adidasSkuService;
	
	/**
	 * 使用原来的service
	 */
	@Autowired
	private CreateStockService createStockService;
	
	
	public MyTestServiceImpl() {
	}
	/**
	 * 提供显式的构造方法
	 * @param createOrderService
	 */
	public MyTestServiceImpl(CreateOrderService createOrderService, CreateSkuService adidasSkuService, CreateStockService createStockService) {
		this();
		this.createOrderService = createOrderService;
		this.adidasSkuService = adidasSkuService;
		this.createStockService = createStockService;
	}

	/**
	 * 默认的创单方法
	 */
	@Override
	public String createOrder(String shopId) {
		System.out.println("adidas2 create order begin..." + shopId);
		this.createOrderService.createOrder(shopId);
		this.createOrderService.createSku(shopId);
		
		System.out.println("adidas2 create order end..." + shopId);
		System.out.println("adidas2 create logistics...");
		this.adidasSkuService.createSku(shopId);
		System.out.println("adidas2 check sku finished...");
		
		this.createStockService.createStock(shopId);
		
		return shopId;
	}

}

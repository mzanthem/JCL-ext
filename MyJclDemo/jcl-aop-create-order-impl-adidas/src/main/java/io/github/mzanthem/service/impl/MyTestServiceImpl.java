/*
 * MyTestServiceImpl.java Created On 2018年11月28日
 * Copyright(c) 2018 Mazan Inc.
 * ALL Rights Reserved.
 */
package io.github.mzanthem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.mzanthem.service.AdidasSkuService;
import io.github.mzanthem.service.CreateOrderService;
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
	private AdidasSkuService adidasSkuService;
	
	public MyTestServiceImpl() {
	}
	/**
	 * 提供显式的构造方法
	 * @param createOrderService
	 */
	public MyTestServiceImpl(CreateOrderService createOrderService, AdidasSkuService adidasSkuService) {
		this();
		this.createOrderService = createOrderService;
		this.adidasSkuService = adidasSkuService;
	}

	/**
	 * 默认的创单方法
	 */
	@Override
	public String createOrder(String shopId) {
		System.out.println("adidas create order begin..." + shopId);
		this.createOrderService.createOrder(shopId);
		this.createOrderService.createSku(shopId);
		
		System.out.println("adidas create order end..." + shopId);
		System.out.println("adidas create logistics...");
		
		this.adidasSkuService.checkSku();
		System.out.println("adidas check sku finished...");
		return shopId;
	}

}

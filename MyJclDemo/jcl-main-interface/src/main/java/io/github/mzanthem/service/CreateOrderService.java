/*
 * CreateOrderService.java Created On 2018年11月28日
 * Copyright(c) 2018 Mazan Inc.
 * ALL Rights Reserved.
 */
package io.github.mzanthem.service;
/**
 * CreateOrderService
 *
 * @time: 下午2:39:00
 * @author mazan
 */
public interface CreateOrderService {

	public void createOrder(String shopId);
	
	public void createSku(String shopId);
}

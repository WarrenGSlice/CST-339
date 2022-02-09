package com.gcu.business;

import java.util.List;

import com.gcu.entity.OrderEntity;

public interface OrdersBusinessInterface {

	public void test();

	public List<OrderEntity> getOrders();

	public void init();

	public void destroy();
}

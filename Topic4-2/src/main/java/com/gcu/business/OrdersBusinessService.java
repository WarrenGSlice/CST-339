package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.OrderDataService;
import com.gcu.entity.OrderEntity;
import com.gcu.model.OrderModel;

public class OrdersBusinessService implements OrdersBusinessInterface{

	@Autowired
	private OrderDataService service;
	
	@Override
	public void test() {
		System.out.println("Hello from the OrdersBusinessService");
	}


	@Override
	public List<OrderModel> getOrders() {
		
		// Get all all the Entity Orders
		List<OrderEntity> ordersEntity = service.findAll();
		
		// Iterate over the Entity Orders and create a list of Domain orders
		List<OrderModel> ordersDomain = new ArrayList<OrderModel>();
		for(OrderEntity entity : ordersEntity)
		{
			ordersDomain.add(new OrderModel(entity.getId(), entity.getOrderNo(), 
					entity.getProductName(), entity.getPrice(), entity.getQuantity()));
		}
		// Return a List of Domain Orders
		return ordersDomain;
	}

	@Override
	public void init() {
		System.out.println("This is a test of init() from OrdersBusinessService");

	}

	@Override

	public void destroy() {
		System.out.println("This is a test of destroy() from OrdersBusinessService");

	}
}

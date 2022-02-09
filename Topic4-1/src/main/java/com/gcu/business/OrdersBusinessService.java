package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.gcu.model.OrderModel;


public class OrdersBusinessService implements OrdersBusinessInterface{

	@Autowired
	private DataAccessInterface<OrderModel> service;
	
	@Override
	public void test() {
		System.out.println("Hello from the OrdersBusinessService");
	}


	@Override
	public List<OrderModel> getOrders() {
		
		return service.findAll();
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

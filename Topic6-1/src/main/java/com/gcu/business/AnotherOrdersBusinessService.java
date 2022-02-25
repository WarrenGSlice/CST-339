package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.model.OrderModel;

public class AnotherOrdersBusinessService implements OrdersBusinessInterface{

	@Override
	public void test() {
		System.out.println("Hello from the AnotherOrdersBusinessService");
	}


	@Override
	public List<OrderModel> getOrders() {

		List<OrderModel> orders = new ArrayList<>();
		orders.add(new OrderModel("0L", "0000000001", "AnotherOrder 1", 1.00f, 1));
		orders.add(new OrderModel("1L", "0000000002", "AnotherOrder 2", 2.00f, 2));
		orders.add(new OrderModel("2L", "0000000003", "AnotherOrder 3", 3.00f, 3));
		orders.add(new OrderModel("3L", "0000000004", "AnotherOrder 4", 4.00f, 4));
		orders.add(new OrderModel("4L", "0000000005", "AnotherOrder 5", 5.00f, 5));
		return orders;
	}

	@Override
	public void init() {
		System.out.println("This is a test of init() from AnotherOrdersBusinessService");

	}

	@Override
	public void destroy() {
		System.out.println("This is a test of destroy() from AnotherOrdersBusinessService");

	}


	@Override
	public OrderModel getOrderById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}

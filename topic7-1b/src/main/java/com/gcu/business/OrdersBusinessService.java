package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.entity.OrderEntity;
import com.gcu.model.OrderModel;
import com.gcu.repository.OrdersRepository;
@Service
public class OrdersBusinessService {

	@Autowired
	private OrdersRepository ordersRepository;
	
	/**
	 * Non-Default Constructor for constructor injection
	 * @param ordersRepository
	 */
	public OrdersBusinessService(OrdersRepository ordersRepository)
	{
		this.ordersRepository = ordersRepository;
	}

	/**
	 * Get all the Orders from the database
	 * @return
	 */
	public List<OrderModel> getAllOrders() {
		System.out.println("Generating a list from getOrders()");
		// Get all all the Entity Orders
		List<OrderEntity> ordersEntity = ordersRepository.findAll();
		
		// Option 2: Iterate over the Entity Orders and create a list of Domain orders
		List<OrderModel> ordersDomain = new ArrayList<OrderModel>();
		for(OrderEntity entity : ordersEntity)
		{
			ordersDomain.add(new OrderModel(entity.getId(), entity.getOrderNo(), 
					entity.getProductName(), entity.getPrice(), entity.getQuantity()));
		}
		// Return a List of Domain Orders
		return ordersDomain;
	}


	public void init() {
		System.out.println("This is a test of init() from OrdersBusinessService");

	}

	public void destroy() {
		System.out.println("This is a test of destroy() from OrdersBusinessService");

	}


//	public OrderModel getOrderById(String id) {
//		// Get the Entity Order
//		OrderEntity orderEntity = service.findById(id);
//		
//		// Convert Entity Order to Domain Order
//		return new OrderModel(orderEntity.getId(), orderEntity.getOrderNo(), orderEntity.getProductName(), orderEntity.getPrice(), orderEntity.getQuantity());
//	}
}

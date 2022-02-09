package com.gcu.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.entity.OrderEntity;
import com.gcu.repository.OrdersRepository;

@Service
public class OrderDataService implements DataAccessInterface<OrderEntity> {
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	/**
	 * Non-default Constructor for constructor injection
	 */
	public OrderDataService(OrdersRepository ordersRepository) {
		this.ordersRepository = ordersRepository;
	}

	/**
	 * CRUD: finder to return a single entity
	 */
	@Override
	public Optional<OrderEntity> findById(Long id) {
		
		return  ordersRepository.findById(id);
	}
	
	/**
	 * CRUD: finder to return all entities
	 */
	@Override
	public List<OrderEntity> findAll() {

		List<OrderEntity> orders = new ArrayList<OrderEntity>();
		try
		{
			// Get all all the Entity Orders
			Iterable<OrderEntity> ordersIterable = ordersRepository.findAll();

			// Convert to a List and return the List
			orders = new ArrayList<OrderEntity>();
			ordersIterable.forEach(orders::add);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		// Return the List
		return orders;
	}


	/**
	 * CRUD: create an entity
	 */
	@Override
	public boolean create(OrderEntity order) {

		try
		{
			this.ordersRepository.save(order);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		// Return the List
		return true;
	}

	@Override
	public boolean update(OrderEntity order) {
		
		
		// Return the List
		return ordersRepository.save(order) != null;
	}

	@Override
	public boolean delete(OrderEntity order) {
		try
		{
			this.ordersRepository.delete(order);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
			
		}
		// Return the List
		return true;
	}
}
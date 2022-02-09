package com.gcu.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.gcu.entity.OrderEntity;
import com.gcu.repository.OrdersRepository;

@Service
public class OrderDataService implements DataAccessInterface<OrderEntity> {
	
	@Autowired
	private OrdersRepository ordersRepository;
	@SuppressWarnings("unused")
	private DataSource dataSource;
	@SuppressWarnings("unused")
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * Non-default Constructor for constructor injection
	 */
	public OrderDataService(OrdersRepository ordersRepository, DataSource dataSource) {
		this.ordersRepository = ordersRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
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
		// Example of "overriding" the CrudRepository save() because it simple is never called
		// You can inject a dataSource and use the jdbcTemplate to provide a customized implementation of a save() method
		String sql = "INSERT INTO ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES(?, ?, ?, ?)";
		try
		{
			// Execute SQL Insert
			jdbcTemplateObject.update(sql,
										order.getOrderNo(),
										order.getProductName(),
										order.getPrice(),
										order.getQuantity());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
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
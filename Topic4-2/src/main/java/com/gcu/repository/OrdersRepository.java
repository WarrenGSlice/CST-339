package com.gcu.repository;

import org.springframework.data.repository.CrudRepository;

import com.gcu.entity.OrderEntity;

public interface OrdersRepository extends CrudRepository<OrderEntity,Long> {
	
	

}

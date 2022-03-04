package com.gcu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gcu.entity.OrderEntity;

public interface OrdersRepository extends MongoRepository<OrderEntity,String> {
	
	OrderEntity getOrderById(String id);

}

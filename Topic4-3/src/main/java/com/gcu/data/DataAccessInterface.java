package com.gcu.data;

import java.util.List;
import java.util.Optional;

import com.gcu.entity.OrderEntity;

public interface DataAccessInterface<T> {

	public List<T> findAll();
	public Optional<OrderEntity> findById(Long id);
	public boolean create(T t);
	public boolean update(T t);
	public boolean delete(T t);
}

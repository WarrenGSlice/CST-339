package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.DataAccessInterface;
import com.gcu.entity.OrderEntity;
import com.gcu.entity.UserEntity;
import com.gcu.repository.UsersRepository;
@Service
public class UsersDataService implements UsersDataAccessInterface<UserEntity>, DataAccessInterface<UserEntity>{

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public List<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderEntity findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(UserEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(UserEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(UserEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * CRUD: finder to return an entity by User Name
	 */
	public UserEntity findByUsername(String username) {
		return usersRepository.findByUsername(username);
	}
}

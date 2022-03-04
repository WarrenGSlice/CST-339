package com.gcu.business;

import com.gcu.entity.UserEntity;
import com.gcu.model.UserModel;
import com.gcu.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserBusinessService {

	@Autowired
	private UsersRepository usersRepository;
	
	/**
	 * Non-Default Constructor for contructor injection
	 * @param usersRepository
	 */
	public UserBusinessService(UsersRepository usersRepository)
	{
		this.usersRepository = usersRepository;
	}
	
	/**
	 *  Get all Users from the database
	 * @return usersDomain
	 */
	public List<UserModel> getAllUsers()
	{
		// Get all the Entity Users
		List<UserEntity> usersEntity = usersRepository.findAll();
		// Iterate over the Entity Users and create a list of Domain Users
		List<UserModel> usersDomain = new ArrayList<UserModel>();
		for(UserEntity user : usersEntity)
		{
			usersDomain.add(new UserModel(user.getId(), user.getUsername(), user.getPassword()));
		}
		// Return list of Domain Users
		return usersDomain;
	}
	
	
}

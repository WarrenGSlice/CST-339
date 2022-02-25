package com.gcu.business;

public interface UsersDataAccessInterface <T> {

	public T findByUsername(String username);
}

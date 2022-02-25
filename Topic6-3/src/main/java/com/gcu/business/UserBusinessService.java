package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gcu.entity.UserEntity;
@Service
public class UserBusinessService implements UserDetailsService{

	@Autowired
	private UsersDataService usersDataService;
	
	public UserBusinessService(UsersDataService usersDataService) {
		this.usersDataService = usersDataService;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Try to find the User in the Database. If not found, throw a User Not Found Exception else return a Spring Security User.
		UserEntity user = usersDataService.findByUsername(username);
		if(user!=null)
		{
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("USER"));
			return new User(user.getUsername(), user.getPassword(), authorities);
		}
		else
		{
			throw new UsernameNotFoundException("username not found");
		}

	}

}

package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gcu.business.UserBusinessService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserBusinessService service;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	private CharSequence plainTextPassword = "test";
	
	
	@Bean
	BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable()
			.authorizeRequests()
				.antMatchers("/", "/images/**", "/service/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.usernameParameter("username")
				.passwordParameter("password")
				.permitAll()
				.defaultSuccessUrl("/orders/display", true)
				.and()
			.logout()
				.logoutUrl("/logout")
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.permitAll()
				.logoutSuccessUrl("/");
	}
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth
		.userDetailsService(service)
		.passwordEncoder(passwordEncoder);
		
		String encoded = new BCryptPasswordEncoder().encode(plainTextPassword);
		System.out.println(encoded);
	}
	
	


}
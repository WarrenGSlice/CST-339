package com.gcu.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String display(Model model) {
		// Display the Login Form
		model.addAttribute("title", "Login Form");
		return "login";
	}
	
	String encoded = new BCryptPasswordEncoder().encode("test");
	//System.out.println("");

//	@PostMapping("/doLogin")
//	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
//
//		service.test();
//		security.authenticate("username","password");
//
//		// Check for validation errors
//		if (bindingResult.hasErrors()) {
//			model.addAttribute("title", "Login Form");
//			return "login";
//		}
//
//
//		service.getOrders();
//		
//		
//
//		// Display the Orders View
//		model.addAttribute("title", "My Orders");
//		model.addAttribute("orders", service.getOrders());
//		return "orders";
//	}
}

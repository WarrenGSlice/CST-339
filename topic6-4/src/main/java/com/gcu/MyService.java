package com.gcu;

import org.springframework.boot.actuate.trace.http.HttpTrace.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class MyService {

	@GetMapping("/test")
	public String test(Principal principal)
	{
		return "Hello " + principal.getName() + " and welcome to my protected service!!";	
	}
}

package com.surya.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surya.repositories.User;
import com.surya.userdetailsconfig.SecurityUser;

@RestController
@RequestMapping(value="/")
public class DemoController {
	@Autowired
	@Lazy
	JdbcUserDetailsManager udm;
	@Autowired
	@Lazy
	PasswordEncoder pe;
	@GetMapping("/hello")
public String hello()
{
	
	BCryptPasswordEncoder b=new BCryptPasswordEncoder();
	b.encode("surya");
	System.out.println(b.encode("surya"));
	return "hello";
}
	@PostMapping("/adduser")
	public void addUser(@RequestBody User user)
	{
		String password=user.getPassword();
		user.setPassword(pe.encode(password));
		SecurityUser securityUser=new SecurityUser(user);
		udm.createUser(securityUser);
		
	}
}

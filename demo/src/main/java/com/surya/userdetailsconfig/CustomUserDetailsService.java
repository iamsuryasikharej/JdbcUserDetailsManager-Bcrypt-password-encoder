package com.surya.userdetailsconfig;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import com.surya.repositories.User;
import com.surya.repositories.UserRepository;

public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	UserRepository ur;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user=ur.findUserByUname(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("User Name not Found");
		}
		return new SecurityUser(user);
	
}
}
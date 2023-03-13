package com.surya.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Component
public interface UserRepository extends JpaRepository<User,Integer> {
	User findUserByUname(String uname);
	
}


package com.Far.rayatechibazarpeth.rayatechibazarpeth.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.Far.rayatechibazarpeth.rayatechibazarpeth.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email); 
    

	User findByEmailAndPassword(String email, String password);

	
	
	}


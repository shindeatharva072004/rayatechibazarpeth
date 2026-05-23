package com.Far.rayatechibazarpeth.rayatechibazarpeth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Far.rayatechibazarpeth.rayatechibazarpeth.entity.Admin;



public interface AdminRepository  extends JpaRepository<Admin, Integer>{

	
	Admin findByEmailAndPassword(String email, String password);
}


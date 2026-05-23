package com.Far.rayatechibazarpeth.rayatechibazarpeth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Far.rayatechibazarpeth.rayatechibazarpeth.entity.FarmerDetails;

public interface FarmerDetailsRepository  extends JpaRepository<FarmerDetails,Integer> {
	List<FarmerDetails> findByProductNameAndLocation(String productName, String location); // Corrected name
	    // ... other methods ...
	
	List<FarmerDetails> findByVerificationstatus(String verificationstatus);

	}

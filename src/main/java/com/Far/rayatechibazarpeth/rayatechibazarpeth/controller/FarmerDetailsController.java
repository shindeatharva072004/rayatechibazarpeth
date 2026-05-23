package com.Far.rayatechibazarpeth.rayatechibazarpeth.controller;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Far.rayatechibazarpeth.rayatechibazarpeth.DTO.FarmerDetailsDTO;

import com.Far.rayatechibazarpeth.rayatechibazarpeth.entity.FarmerDetails;
import com.Far.rayatechibazarpeth.rayatechibazarpeth.entity.User;
import com.Far.rayatechibazarpeth.rayatechibazarpeth.repository.UserRepository;
import com.Far.rayatechibazarpeth.rayatechibazarpeth.service.FarmerDetailsService;


import jakarta.servlet.http.HttpSession;

@Controller
public class FarmerDetailsController {
	
	@Autowired
	private  FarmerDetailsService farmerdetailsserobj;
	
	@Autowired
	private UserRepository userrepobj;

	@PostMapping("/farmers/add")
	public String addFarmerDetails(@ModelAttribute FarmerDetailsDTO farmerDetailsDTO,
	                               @RequestParam("productImage") MultipartFile productImage,  
	                               HttpSession session) {
	    try {
	        
	    	User loggedInUser = (User) session.getAttribute("LoggedInUser");
	        
	        if (loggedInUser == null) {
	            return "redirect:/login"; // Redirect to login page if user is not logged in
	        } 

	        FarmerDetails farmerDetails = new FarmerDetails();
	        farmerDetails.setUser(loggedInUser); // Assign logged-in user to farmer details

	        // Set other fields from the DTO
	        farmerDetails.setFarmername(farmerDetailsDTO.getFarmerName());
	        farmerDetails.setDescription(farmerDetailsDTO.getDescription());
	        farmerDetails.setContact(farmerDetailsDTO.getContact());
	        farmerDetails.setPerkgrate(farmerDetailsDTO.getPerKgRate());
	        farmerDetails.setLocation(farmerDetailsDTO.getLocation());
	        farmerDetails.setIdproof(farmerDetailsDTO.getIdProof());
	        farmerDetails.setIdproofnumber(farmerDetailsDTO.getIdProofNumber());
	        farmerDetails.setPayment(farmerDetailsDTO.getPayment());
	        farmerDetails.setVerificationstatus(farmerDetailsDTO.getVerificationStatus());
	        farmerDetails.setProductimage(farmerDetailsDTO.getProductimage());
	        farmerDetails.setStartDate(farmerDetailsDTO.getStartDate());
	        farmerDetails.setEndDate(farmerDetailsDTO.getEndDate());
	        farmerDetails.setProductName(farmerDetailsDTO.getProductName());

	        System.out.println("Verification Status: " + farmerDetailsDTO.getVerificationStatus());

	        // Save the farmer details
	        farmerdetailsserobj.saveFarmerDetails(farmerDetails, productImage);

	        return "redirect:/farmers/success";  // Redirect to success page

	    } catch (IOException e) {
	        e.printStackTrace();
	        return "farmers";  // Redirect to farmer page in case of error
	    }
	}


	@GetMapping("farmer/farmersdetails")
	public String showFarmerPage(Model model, HttpSession session) {
	    List<FarmerDetails> farmers = farmerdetailsserobj.getAllFarmersdetails();
	    model.addAttribute("farmers", farmers);
	    model.addAttribute("user", session.getAttribute("LoggedInUser"));
	    return "Farmer"; 
	}
}

	



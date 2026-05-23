package com.Far.rayatechibazarpeth.rayatechibazarpeth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImageController {

	
	@GetMapping("/") 
	
	public String showImagePage() 
	
	{
		return "Home"; 
    }
}
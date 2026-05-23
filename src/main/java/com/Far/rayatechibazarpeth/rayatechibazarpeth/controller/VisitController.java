package com.Far.rayatechibazarpeth.rayatechibazarpeth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Far.rayatechibazarpeth.rayatechibazarpeth.entity.FarmerDetails;
import com.Far.rayatechibazarpeth.rayatechibazarpeth.service.FarmerDetailsService;



@Controller
public class VisitController { // Or a more appropriate name

    @Autowired
    private FarmerDetailsService farmerDetailsService;

    @PostMapping("/fetch/visit/add") // Matches your form action
    public String fetchFarmerDetails(@RequestParam("product") String product,
                                     @RequestParam("location") String location,
                                     Model model) {

        List<FarmerDetails> farmerDetails = farmerDetailsService.findByProductAndLocation(product, location);

        model.addAttribute("productName", product); // Add product to the model
        model.addAttribute("location", location);   // Add location to the model
        model.addAttribute("farmerdetails", farmerDetails); // Add the list to the model

        return "visit"; // Returns the name of your Thymeleaf template (visit.html)
    }

    @GetMapping("/fetch/visit") // If you want a GET mapping to the visit page
    public String showVisitPage(Model model) {
        // You might want to add some default values or an empty list here
        // if the user hasn't submitted the form yet.
        model.addAttribute("productName", "");
        model.addAttribute("location", "");
        model.addAttribute("farmerdetails", List.of()); // Empty list
        return "visit";
    }
}
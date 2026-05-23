package com.Far.rayatechibazarpeth.rayatechibazarpeth.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Far.rayatechibazarpeth.rayatechibazarpeth.entity.FarmerDetails;

import com.Far.rayatechibazarpeth.rayatechibazarpeth.repository.FarmerDetailsRepository;
import com.Far.rayatechibazarpeth.rayatechibazarpeth.repository.UserRepository;

@Service
public class FarmerDetailsService {

    @Autowired
    private FarmerDetailsRepository farmerDetailsrepobj;

    @Autowired 
    private UserRepository userrepobj;

    // ✅ Save Farmer Details with Image Upload
    public void saveFarmerDetails(FarmerDetails farmerDetails, MultipartFile productImage) throws IOException {
        if (!productImage.isEmpty()) {
            String fileName = System.currentTimeMillis() + "_" + productImage.getOriginalFilename(); // Unique filename
            String uploadDir = "uploads/farmers/"; // Use a subfolder for better organization
            Path filePath = Paths.get(uploadDir, fileName);

            // Ensure directory exists
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, productImage.getBytes());

            // Save image path in database
            farmerDetails.setProductimage(filePath.toString());
        }

        // Save farmer details
        farmerDetailsrepobj.save(farmerDetails);
    }

    // ✅ Fetch all farmers
    public List<FarmerDetails> getAllFarmersdetails() {
        return farmerDetailsrepobj.findAll();
    }

    // ✅ Fetch farmers by Product & Location
    public List<FarmerDetails> findByProductAndLocation(String product, String location) {
        return farmerDetailsrepobj.findByProductNameAndLocation(product, location);
    }
 // ✅ Fetch Unverified Farmers for Admin Notification
    public List<FarmerDetails> getUnverifiedFarmers() {
        return farmerDetailsrepobj.findByVerificationstatus("Pending"); // Assuming "Pending" means unverified
    }


}

package com.Far.rayatechibazarpeth.rayatechibazarpeth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Far.rayatechibazarpeth.rayatechibazarpeth.entity.FarmerDetails;
import com.Far.rayatechibazarpeth.rayatechibazarpeth.entity.Visit;
import com.Far.rayatechibazarpeth.rayatechibazarpeth.repository.FarmerDetailsRepository;
import com.Far.rayatechibazarpeth.rayatechibazarpeth.repository.VisitRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VisitService {

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private FarmerDetailsRepository farmerDetailsRepository; // ✅ Correct injection

    public void recordVisit(Integer userId, Integer product_id) {
        Visit visit = new Visit();
        visit.setUser_Id(userId);
        visit.setProductId(product_id);
        visit.setVisitDate(LocalDateTime.now()); 
        
        visitRepository.save(visit);
    }

    public List<FarmerDetails> getFarmerDetailsByProductAndLocation(String product, String location) {
        return farmerDetailsRepository.findByProductNameAndLocation(product, location); // ✅ Corrected usage
    }
}

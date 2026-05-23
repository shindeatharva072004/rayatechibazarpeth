package com.Far.rayatechibazarpeth.rayatechibazarpeth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Far.rayatechibazarpeth.rayatechibazarpeth.DTO.AdminDTO;
import com.Far.rayatechibazarpeth.rayatechibazarpeth.entity.Admin;
import com.Far.rayatechibazarpeth.rayatechibazarpeth.repository.AdminRepository;

@Service
public class AdminService {

	 @Autowired
	    private AdminRepository adminrepobj;

	    public String addAdmin(Admin admin) {
	        adminrepobj.save(admin);
	        return "Admin Added";
	    }
	    
	    
	    public String adminregisterservice(AdminDTO admindtoobj) {
	        Admin admin = new Admin();
	        admin.setName(admindtoobj.getName());
	        admin.setEmail(admindtoobj.getEmail());
	        admin.setPassword(admindtoobj.getPassword());
	        adminrepobj.save(admin);
	        return "Admin Registered";
	    }

	    public String verifyadmin(String email, String password) {
	        Admin admin = adminrepobj.findByEmailAndPassword(email, password);
	        if (admin != null)
	            return "success";
	        else
	            return "fail";
	    }	    
}

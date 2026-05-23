package com.Far.rayatechibazarpeth.rayatechibazarpeth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Far.rayatechibazarpeth.rayatechibazarpeth.DTO.userdto;
import com.Far.rayatechibazarpeth.rayatechibazarpeth.entity.Product;
import com.Far.rayatechibazarpeth.rayatechibazarpeth.entity.User;
import com.Far.rayatechibazarpeth.rayatechibazarpeth.service.ProductService;
import com.Far.rayatechibazarpeth.rayatechibazarpeth.service.UserService;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
	  
		@Autowired
	    private UserService userserobj;
	    
	    
		@Autowired
	    private ProductService productserviceobj;

	    @PostMapping("/adduser")
	    public String addUser(@RequestBody User user) {
	        return userserobj.addUser(user);
	    }
	    
		@GetMapping("/registeruser")
		public String registerpage()
		{
			return "UserRegistration";
		}
		
		@PostMapping("/registeruser")
		public String useregister(@Valid @RequestParam String username,
		                          @RequestParam String email,
		                          @RequestParam String password,
		                          @RequestParam String phoneno,  // ✅ Allow NULL values
		                          @RequestParam String user_type) {
		    userdto userdtoobj = new userdto();
		    userdtoobj.setName(username);
		    userdtoobj.setEmail(email);
		    userdtoobj.setPassword(password);

		    if (phoneno != null) {  
		        userdtoobj.setPhone_no(phoneno);
		    } else {
		        return "ErrorPage"; 
		    }

		    userdtoobj.setUser_type(user_type);
		    userserobj.userregisterservice(userdtoobj);
		    return "UserLogin";
		}
		
		
		@PostMapping("/login")
		public String userlogin(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
		    String message = userserobj.verifyuser(email, password);
		    if (message.equals("success")) {
		        session.setAttribute("LoggedInUser", email);
		      
		        User loggedInUser = userserobj.getfindByEmail(email); 
		        

		        session.setAttribute("LoggedInUser", loggedInUser);

		     
		        List<Product> products = productserviceobj.fetchproduct();
		        model.addAttribute("product", products);
		        
		        return "Dashboard";  
		    } else {
		        return "UserLogin";
		    }
		}

	    @GetMapping("/login")
	    public String userlogin() {
	    	
	    	return "UserLogin";
	    }

	    
	    @GetMapping("/fetchuser")
	    public List<User> fetchuser()
	    {
	        List<User> userlist = userserobj.fetchuser();
	        return userlist;
	    }

	    @DeleteMapping("/deleteuser/{id}")
	    public String deleteuser(@PathVariable Integer id)
	    {
	        userserobj.deleteuser(id);
	        return "Data Deleted";
	    }

	    @PutMapping("/updateuser/{id}")
	    public String updateuser(@PathVariable Integer id, @RequestBody User user) 
	    {
	       userserobj.updateuser(id, user);
	       return "Data Updated";
	   
	    }
	 
	   }





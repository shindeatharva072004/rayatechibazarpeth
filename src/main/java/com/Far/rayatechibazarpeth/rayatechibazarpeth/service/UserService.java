package com.Far.rayatechibazarpeth.rayatechibazarpeth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Far.rayatechibazarpeth.rayatechibazarpeth.DTO.userdto;
import com.Far.rayatechibazarpeth.rayatechibazarpeth.entity.User;

import com.Far.rayatechibazarpeth.rayatechibazarpeth.repository.UserRepository;


@Service
public class UserService {
	
	 @Autowired
	    private UserRepository userrepobj;
	 

	    public User getfindByEmail(String email) {
	        return userrepobj.findByEmail(email); // Assuming you have a findByEmail method in your UserRepository
	    }

	    public String addUser(User user) {
	        userrepobj.save(user);
	        return "User Added";
	    }
	    
	    public String userregisterservice(userdto userdtoobj)
		{
			User user = new User();
			user.setUsername(userdtoobj.getName());
			user.setEmail(userdtoobj.getEmail());
			user.setPassword(userdtoobj.getPassword());
			user.setPhone_no(userdtoobj.getPhone_no());
			user.setUser_type(userdtoobj.getUser_type());
			userrepobj.save(user);
			return "user Registered";
		}
	
	       
	    
	    public String verifyuser(String email, String password) {
	        User user = userrepobj.findByEmailAndPassword(email, password);
	        if (user != null)
	            return "success";
	        else
	            return "fail";
	    }


	    public List<User> fetchuser() {
	        List<User> userlist = userrepobj.findAll();
	        return userlist;
	    }

	    public String deleteuser(Integer id) {
	        userrepobj.deleteById(id);
	        return "Data Deleted";
	    }

	    public String updateuser (Integer id,User user) {
	      
	        userrepobj.save(user);
	        return "Data Updated";
	    }

		public static User findUserEmailAndId(String loggedInUserEmail) {
			// TODO Auto-generated method stub
			return null;
		}

	

		

	
	

		

		

	    
}

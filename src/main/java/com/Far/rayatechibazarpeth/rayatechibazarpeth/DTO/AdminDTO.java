package com.Far.rayatechibazarpeth.rayatechibazarpeth.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AdminDTO {

	
	
	@NotBlank(message="Field cannot be blank")
	@Size(min=3,max=12,message="It cannot be less than 3 charater")
	private String name;
	
	@NotBlank(message="field cannot be blank")
	@Email(message="Field should have valid email")
	private String email;
	
	@NotBlank(message="field cannot be blank")
	@Size(min=8,message = "Password field should have minimum 8 charaters")
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

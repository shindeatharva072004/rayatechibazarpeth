package com.Far.rayatechibazarpeth.rayatechibazarpeth.DTO;



import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Table(name = "users")
public class userdto {
	
	 private Integer user_id; 
	
	
	 @NotBlank(message = "Field cannot be blank")
	    @Size(min = 3, max = 12, message = "It cannot be less than 3 characters")
	    private String username;

	    @NotBlank(message = "Field cannot be blank")
	    @Email(message = "Field should have a valid email")
	    private String email;

	    @NotBlank(message = "Field cannot be blank")
	    @Size(min = 8, message = "Password field should have minimum 8 characters")
	    private String password;

	    @NotNull(message = "Field cannot be null")
	    @Digits(integer = 10, fraction = 0, message = "Phone number must have 10 digits")
	    private String phone_no;

	    @NotBlank(message = "Field cannot be blank")
	    @Pattern(regexp = "^(admin|user|moderator)$", message = "User type must be admin, user, or moderator")
	    private String user_type;

	    public String getName() {
	        return username;
	    }

	    public void setName(String name) {
	        this.username = name;
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

	  

	    public String getUser_type() {
	        return user_type;
	    }

	    public void setUser_type(String user_type) {
	        this.user_type = user_type;
	    }

		public Integer getUser_id() {
			return user_id;
		}

		public void setUser_id(Integer user_id) {
			this.user_id = user_id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPhone_no() {
			return phone_no;
		}

		public void setPhone_no(String phone_no) {
			this.phone_no = phone_no;
		}
		
		


		
	
	
}
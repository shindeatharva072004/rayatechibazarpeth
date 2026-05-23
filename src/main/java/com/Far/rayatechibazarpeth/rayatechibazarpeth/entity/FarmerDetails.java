package com.Far.rayatechibazarpeth.rayatechibazarpeth.entity;


import java.time.LocalDate;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table(name = "farmer_details")
public class FarmerDetails {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  Integer id;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")  // Foreign key column
	private User user;
	private String farmername;

	private String description;
	private String productName; 

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	private String contact;
	private double perkgrate;
	private String productimage;
	
	private String location;
	
	 private LocalDate startDate;  // New Field
	    private LocalDate endDate;
	    
	    
	  
	private String Idproof;
	private String Idproofnumber;
	private String payment;
	private String verificationstatus;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getFarmername() {
		return farmername;
	}
	public void setFarmername(String farmername) {
		this.farmername = farmername;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public double getPerkgrate() {
		return perkgrate;
	}
	public void setPerkgrate(double perkgrate) {
		this.perkgrate = perkgrate;
	}
	public String getProductimage() {
		return productimage;
	}
	public void setProductimage(String productimage) {
		this.productimage = productimage;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getIdproof() {
		return Idproof;
	}
	public void setIdproof(String idproof) {
		Idproof = idproof;
	}
	public String getIdproofnumber() {
		return Idproofnumber;
	}
	public void setIdproofnumber(String idproofnumber) {
		Idproofnumber = idproofnumber;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getVerificationstatus() {
		return verificationstatus;
	}
	public void setVerificationstatus(String verificationstatus) {
		this.verificationstatus = verificationstatus;
	}
	
	
	
	
	
	
	
}
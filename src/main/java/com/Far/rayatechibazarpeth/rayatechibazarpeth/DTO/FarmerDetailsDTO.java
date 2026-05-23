package com.Far.rayatechibazarpeth.rayatechibazarpeth.DTO;




import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class FarmerDetailsDTO {


    @NotBlank(message = "Field cannot be blank")
    private String idProof;

    @NotNull(message = "Field cannot be blank")
    private String idProofNumber;

    @NotBlank(message = "Field cannot be blank")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must have 10 digits")
    private String contact;

   


	@NotBlank(message = "Field cannot be blank")
    private String description;

  
    @NotBlank(message = "Field cannot be blank")
    private String farmerName;

    @NotBlank(message = "Field cannot be blank")
    private String productimage;

    @NotNull(message = "Field cannot be null")
    @Positive(message = "Payment rate per kg must be a positive number")
    private double PerKgRate;

    @NotBlank(message = "Field cannot be blank")
    private String productName;

    @NotBlank(message = "Field cannot be blank")
    @Pattern(regexp = "(verified|pending)", message = "Verification status must be either 'verified' or 'pending'")
    private String verificationStatus;

    @NotNull(message = "Start date cannot be null")
    private LocalDate startDate;

    @NotNull(message = "End date cannot be null")
    private LocalDate endDate;




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


	@NotBlank(message = "Field cannot be blank")
    private String payment;


    @NotBlank(message = "Location cannot be blank")
    private String location;


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getIdProof() {
		return idProof;
	}


	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}


	


	


	


	public String getIdProofNumber() {
		return idProofNumber;
	}


	public void setIdProofNumber(String idProofNumber) {
		this.idProofNumber = idProofNumber;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}




	public String getFarmerName() {
		return farmerName;
	}


	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}


	public String getProductimage() {
		return productimage;
	}


	public void setProductimage(String productimage) {
		this.productimage = productimage;
	}


	public double getPerKgRate() {
		return PerKgRate;
	}


	public void setPerKgRate(double perKgRate) {
		PerKgRate = perKgRate;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getVerificationStatus() {
		return verificationStatus;
	}


	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}


	public String getPayment() {
		return payment;
	}


	public void setPayment(String payment) {
		this.payment = payment;
	}


	
    
    

}
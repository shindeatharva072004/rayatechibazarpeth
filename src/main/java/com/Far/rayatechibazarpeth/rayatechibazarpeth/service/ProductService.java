package com.Far.rayatechibazarpeth.rayatechibazarpeth.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Far.rayatechibazarpeth.rayatechibazarpeth.entity.Product;
import com.Far.rayatechibazarpeth.rayatechibazarpeth.repository.ProductRepository;


@Service
public class ProductService {
	

	
	@Autowired
	private ProductRepository productrepobj;
	private String uploadDir = "C://Users//atharva shinde//Downloads//rayatechibazarpeth//rayatechibazarpeth//src//main//resources//static//images/";

	public String addproduct(Product product, MultipartFile file) {
	    
	    File directory = new File(uploadDir);
	    System.out.println(directory.getPath());
	    if (!directory.exists()) {
	        directory.mkdirs();
	    }

	   
	    String filePath = uploadDir + file.getOriginalFilename();
	    System.out.println(filePath);
	    try {
	        file.transferTo(new File(filePath));
	    } catch (IllegalStateException | IOException e) {
	        e.printStackTrace();
	    }
	    
	    product.setImage_path(file.getOriginalFilename());
	    productrepobj.save(product);
	    return "Product object saved";
	}
	    
	    
	    public List<Product>fetchproduct(){
	    	List<Product> productlist = productrepobj.findAll();
	    	return productlist;
	    }
	    

	    public void deleteProduct(Integer id) {
	        productrepobj.deleteById(id);
	    }

	    public Product getProductById(Integer id) {
	        return productrepobj.findById(id).orElse(null);
	    }

	    public void saveProduct(Product product) {
	        productrepobj.save(product);
	    }
	    
	    
	    
	    public void updateProduct(Integer id, Product product, MultipartFile file) {
	        Product existingProduct = productrepobj.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

	        existingProduct.setProductname(product.getProductname());
	      
	        

	        if (file != null && !file.isEmpty()) {
	            try {
	                String filePath = uploadDir + file.getOriginalFilename();
	                file.transferTo(new File(filePath));
	                existingProduct.setImage_path(file.getOriginalFilename());
	            } catch (IOException e) {
	                throw new RuntimeException("File upload failed", e);
	            }
	        }

	        productrepobj.save(existingProduct);
	    }
	  
		
	}



package com.Far.rayatechibazarpeth.rayatechibazarpeth.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Far.rayatechibazarpeth.rayatechibazarpeth.entity.Product;

import com.Far.rayatechibazarpeth.rayatechibazarpeth.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	 @Autowired
	    private  ProductService productserobj;

//	    @PostMapping("/addproduct")
//	    public String addUser(@RequestBody Product product) {
//	        return productserobj.addProduct(product);
//	    }
	  
	 
	  @PostMapping("/addproduct")
	  public String addproduct(@RequestPart Product product, @RequestPart("file") MultipartFile file) {
	      
	      productserobj.addproduct(product, file);
	      productserobj.saveProduct(product);
	      return "Product Object Saved";   
	  }
	

	    @GetMapping ("/fetchproduct")
		public List<Product> fetchproduct()
		{
			List<Product> productlist  = productserobj.fetchproduct();
			return productlist;    
			
		}    
		
		@DeleteMapping("/deleteproduct/{id}")
	    public  String deleteproduct (@PathVariable Integer id)
	    {
	   	 productserobj.deleteProduct(id);
	     return "redirect:/admin/addproduct";
	 	
	 	}    
		
		 
	    @GetMapping("/updateproduct/{id}")
	    public String showEditProductForm(@PathVariable Integer id, Model model) {
	        Product product = productserobj.getProductById(id);
	        model.addAttribute("product", product);
	        return "EditProduct";  // This must match the file name
	    }

	    @PostMapping("/updateproduct/{id}")
	    public String updateProduct(
	            @PathVariable Integer id, 
	            @ModelAttribute Product product, 
	            @RequestPart(value = "file", required = false) MultipartFile file) {
	        productserobj.updateProduct(id, product, file);
	        return "redirect:/admin/addproduct";  // Redirect back to the product list
	    }
}
		 
	



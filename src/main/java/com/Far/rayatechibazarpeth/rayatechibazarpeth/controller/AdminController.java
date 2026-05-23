package com.Far.rayatechibazarpeth.rayatechibazarpeth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Far.rayatechibazarpeth.rayatechibazarpeth.DTO.AdminDTO;
import com.Far.rayatechibazarpeth.rayatechibazarpeth.entity.Admin;
import com.Far.rayatechibazarpeth.rayatechibazarpeth.entity.Product;
import com.Far.rayatechibazarpeth.rayatechibazarpeth.service.AdminService;
import com.Far.rayatechibazarpeth.rayatechibazarpeth.service.ProductService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminserobj;

    @Autowired
    private ProductService productService;
    
    @GetMapping("/admin")
    public String showAdminPage() {
        return "Admin"; // Ensure there is a corresponding HTML file in templates
    }


    @PostMapping("/addadmin")
    public String adduserS(@RequestBody Admin admin) {
        return adminserobj.addAdmin(admin);
    }

    @GetMapping("/registeradmin")
    public String registerpage() {
        return "AdminRegister";
    }

    @PostMapping("/registeradmin")
    public String adminregister(@Valid @RequestParam String name,
                                @RequestParam String email,
                                @RequestParam String password) {
        AdminDTO admindtoobj = new AdminDTO();
        admindtoobj.setName(name);
        admindtoobj.setEmail(email);
        admindtoobj.setPassword(password);
        adminserobj.adminregisterservice(admindtoobj);
        return "LoginAdmin";
    }

    @PostMapping("/login")
    public String adminlogin(@RequestParam String email, @RequestParam String password) {
        String message = adminserobj.verifyadmin(email, password);
        if (message.equals("success")) {
            return "DashAdmin.html";
        } else {
            return "LoginAdmin";
        }
    }

    @GetMapping("/login")
    public String customerlogin() {
        return "LoginAdmin";
    }

    @GetMapping("admin/Adddata")
    public String addProductPage(Model model) {    
        model.addAttribute("products", productService.fetchproduct()); // Ensure products are sent to the page
        return "AddData";
    }
    
    

    @PostMapping("/adddata")
    public String addProduct(@RequestParam String name,
                             @RequestParam Integer price,
                             @RequestParam Integer quantity,
                             @RequestParam("file") MultipartFile file) {
        Product product = new Product();
        product.setProductname(name);
       
        productService.addproduct(product, file);
        return "redirect:/admin/AddData";
    }
    
    
    }


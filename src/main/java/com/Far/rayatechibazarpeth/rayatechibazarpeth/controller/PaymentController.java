package com.Far.rayatechibazarpeth.rayatechibazarpeth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentController {

    @GetMapping("farmers/success")
    public String paymentSuccess() {
        return "payment";  
    }
}


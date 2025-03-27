package com.snapp.backend_box.controller;


import com.snapp.backend_box.dto.response.CustomerOutputDto;
import com.snapp.backend_box.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping("/all")
    public ResponseEntity<List<CustomerOutputDto>> getAllCustomer(){
        List<CustomerOutputDto> allCustomer = customerService.getAllCustomer();
        return ResponseEntity.ok(allCustomer);
    }
}
package com.snapp.backend_box.controller;


import com.snapp.backend_box.dto.request.CustomerInputDto;
import com.snapp.backend_box.dto.response.CustomerOutputDto;
import com.snapp.backend_box.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping("/all")
    public ResponseEntity<List<CustomerOutputDto>> getAllCustomer(){
        List<CustomerOutputDto> allCustomer = customerService.getAllCustomer();
        return ResponseEntity.ok(allCustomer);
    }
}
package com.snapp.backend_box.controller;


import com.snapp.backend_box.dto.request.CustomerInputDto;
import com.snapp.backend_box.dto.request.CustomerLoginRequest;
import com.snapp.backend_box.dto.response.CustomerOutputDto;
import com.snapp.backend_box.model.Customer;
import com.snapp.backend_box.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @PostMapping
    public ResponseEntity<CustomerOutputDto> add(@RequestBody CustomerInputDto customerInputDto){
        CustomerOutputDto customerOutputDto = customerService.add(customerInputDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerOutputDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerOutputDto>> getAllCustomer(){
        List<CustomerOutputDto> allCustomer = customerService.getAllCustomer();
        return ResponseEntity.ok(allCustomer);
    }
}
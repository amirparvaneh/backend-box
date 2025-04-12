package com.snapp.backend_box.service.impl;


import com.snapp.backend_box.exception.CustomerException;
import com.snapp.backend_box.repository.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerValidation {

    private final CustomerRepo customerRepo;

    public void validDuplicateCustomer(String email) {
        customerRepo.findByEmail(email).ifPresent(customer -> {
            throw new CustomerException("This customer is duplicate", HttpStatus.NOT_FOUND, email);
        });
    }
}

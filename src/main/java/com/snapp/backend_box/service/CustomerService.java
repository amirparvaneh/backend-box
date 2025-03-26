package com.snapp.backend_box.service;

import com.snapp.backend_box.dto.response.CustomerOutputDto;
import com.snapp.backend_box.model.Customer;

import java.util.List;

public interface CustomerService {
    List<CustomerOutputDto> getAllCustomer();
}

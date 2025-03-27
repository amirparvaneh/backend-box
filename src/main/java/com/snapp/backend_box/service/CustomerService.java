package com.snapp.backend_box.service;

import com.snapp.backend_box.dto.response.CustomerOutputDto;

import java.util.List;

public interface CustomerService {
    List<CustomerOutputDto> getAllCustomer();
}

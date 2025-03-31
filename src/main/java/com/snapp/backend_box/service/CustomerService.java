package com.snapp.backend_box.service;

import com.snapp.backend_box.dto.request.CustomerInputDto;
import com.snapp.backend_box.dto.response.CustomerOutputDto;

import java.util.List;

public interface CustomerService {
    List<CustomerOutputDto> getAllCustomer();
    CustomerOutputDto add(CustomerInputDto customerInputDto);
}

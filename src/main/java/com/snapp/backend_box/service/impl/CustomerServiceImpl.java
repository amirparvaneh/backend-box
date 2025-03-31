package com.snapp.backend_box.service.impl;


import com.snapp.backend_box.dto.request.CustomerInputDto;
import com.snapp.backend_box.dto.response.CustomerOutputDto;
import com.snapp.backend_box.mapper.CustomerMapper;
import com.snapp.backend_box.model.Customer;
import com.snapp.backend_box.repository.CustomerRepo;
import com.snapp.backend_box.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    private final CustomerMapper mapper;

    @Override
    public List<CustomerOutputDto> getAllCustomer() {
        return null;
    }

    @Override
    public CustomerOutputDto add(CustomerInputDto customerInputDto) {
        Customer customer = mapper.customerDtoToCustomer(customerInputDto);
        return mapper.customerToCustomerOutputDot(customerRepo.save(customer));
    }
}

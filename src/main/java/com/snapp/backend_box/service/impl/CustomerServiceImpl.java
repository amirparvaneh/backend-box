package com.snapp.backend_box.service.impl;


import com.snapp.backend_box.dto.request.CustomerInputDto;
import com.snapp.backend_box.dto.response.CustomerOutputDto;
import com.snapp.backend_box.mapper.CustomerMapper;
import com.snapp.backend_box.model.Customer;
import com.snapp.backend_box.repository.CustomerRepo;
import com.snapp.backend_box.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    private final CustomerMapper mapper;

    @Override
    public List<CustomerOutputDto> getAllCustomer() {
        return mapper.listCustomerToDtoList(customerRepo.findAll());
    }

    @Override
    public CustomerOutputDto add(CustomerInputDto customerInputDto) {
        Customer customer = mapper.customerDtoToCustomer(customerInputDto);
        log.info("this is the password "+customer.getPassword());
        customerRepo.save(customer);
        return mapper.customerToCustomerOutputDot(customerRepo.save(customer));
    }

    @Override
    public Customer findByEmail(String email) {
        return customerRepo.findByEmail(email);
    }
}

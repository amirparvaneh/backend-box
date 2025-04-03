package com.snapp.backend_box.service.impl;


import com.snapp.backend_box.dto.request.CustomerInputDto;
import com.snapp.backend_box.dto.response.CustomerOutputDto;
import com.snapp.backend_box.exception.NotFoundException;
import com.snapp.backend_box.mapper.CustomerMapper;
import com.snapp.backend_box.model.Customer;
import com.snapp.backend_box.repository.CustomerRepo;
import com.snapp.backend_box.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    private final CustomerMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<CustomerOutputDto> getAllCustomer() {
        return mapper.listCustomerToDtoList(customerRepo.findAll());
    }

    @Override
    public CustomerOutputDto add(CustomerInputDto customerInputDto) {
        String encode = passwordEncoder.encode(customerInputDto.getPassword());
        Customer customer = mapper.customerDtoToCustomer(customerInputDto);
        customer.setPassword(encode);
        log.info("this is the password "+customer.getPassword());
        customerRepo.save(customer);
        return mapper.customerToCustomerOutputDot(customerRepo.save(customer));
    }

    @Override
    public Customer findByEmail(String email) {
        return customerRepo.findByEmail(email);
    }

    @Override
    public void deleteById(Long id) {
        Customer customer = customerRepo.findById(id).orElseThrow(() ->
                new NotFoundException("the customer not found", HttpStatus.NOT_FOUND, id));
        customerRepo.delete(customer);
    }
}

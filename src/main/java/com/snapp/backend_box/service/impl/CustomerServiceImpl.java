package com.snapp.backend_box.service.impl;


import com.snapp.backend_box.dto.response.CustomerOutputDto;
import com.snapp.backend_box.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerService customerService;

    @Override
    public List<CustomerOutputDto> getAllCustomer() {
        return null;
    }
}

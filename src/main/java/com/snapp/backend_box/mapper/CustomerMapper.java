package com.snapp.backend_box.mapper;


import com.snapp.backend_box.dto.request.CustomerInputDto;
import com.snapp.backend_box.dto.response.CustomerOutputDto;
import com.snapp.backend_box.model.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerInputDto customerInputDto);
    CustomerOutputDto customerToCustomerOutputDot(Customer customer);
    List<CustomerOutputDto> listCustomerToDtoList(List<Customer> customers);
}

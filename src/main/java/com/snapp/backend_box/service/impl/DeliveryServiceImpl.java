package com.snapp.backend_box.service.impl;


import com.snapp.backend_box.dto.request.DeliveryInputDto;
import com.snapp.backend_box.dto.response.DeliveryOutputDto;
import com.snapp.backend_box.exception.NotFoundException;
import com.snapp.backend_box.mapper.DeliveryMapper;
import com.snapp.backend_box.model.Biker;
import com.snapp.backend_box.model.Customer;
import com.snapp.backend_box.model.Delivery;
import com.snapp.backend_box.repository.DeliveryRepo;
import com.snapp.backend_box.service.BikerService;
import com.snapp.backend_box.service.CustomerService;
import com.snapp.backend_box.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepo deliveryRepo;
    private final CustomerService customerService;
    private final BikerService bikerService;
    private final DeliveryMapper deliveryMapper;

    @Override
    public List<DeliveryOutputDto> getAll() {
        List<Delivery> all = deliveryRepo.findAll();
        return deliveryMapper.deliveryToListDto(all);
    }

    @Override
    public Delivery findById(Long id) {
        return deliveryRepo.findById(id).orElseThrow(() ->
                new NotFoundException("delivery not found with this id", HttpStatus.NOT_FOUND, id));
    }

    @Override
    public DeliveryOutputDto add(DeliveryInputDto deliveryInputDto) {
        Customer customer = customerService.findByEmail(deliveryInputDto.getCustomerEmail());
        Biker biker = bikerService.findByEmail(deliveryInputDto.getBikerEmail());
        Delivery delivery = Delivery.builder()
                .customer(customer)
                .biker(biker)
                .deliveryDate(LocalDateTime.now())
                .build();
        Delivery addedDelivery = deliveryRepo.save(delivery);
        return deliveryMapper.deliveryToDto(addedDelivery);
//        return DeliveryOutputDto.builder()
//                .deliveryDate(addedDelivery.getDeliveryDate())
//                .customerEmail(customer.getEmail())
//                .bikerEmail(biker.getEmail()).build();
    }
}

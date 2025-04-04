package com.snapp.backend_box.service.impl;


import com.snapp.backend_box.dto.request.DeliveryInputDto;
import com.snapp.backend_box.dto.response.DeliveryOutputDto;
import com.snapp.backend_box.exception.NotFoundException;
import com.snapp.backend_box.mapper.DeliveryMapper;
import com.snapp.backend_box.model.Biker;
import com.snapp.backend_box.model.Customer;
import com.snapp.backend_box.model.Delivery;
import com.snapp.backend_box.model.Feedback;
import com.snapp.backend_box.repository.DeliveryRepo;
import com.snapp.backend_box.service.BikerService;
import com.snapp.backend_box.service.CustomerService;
import com.snapp.backend_box.service.DeliveryService;
import com.snapp.backend_box.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepo deliveryRepo;
    private final CustomerService customerService;
    private final BikerService bikerService;
    private final FeedbackService feedbackService;
    private final DeliveryMapper deliveryMapper;

    @Override
    public List<DeliveryOutputDto> getAll() {
        return null;
    }

    @Override
    public Delivery findById(Long id) {
        return deliveryRepo.findById(id).orElseThrow(()->
                new NotFoundException("delivery not found with this id", HttpStatus.NOT_FOUND,id));
    }

    @Override
    public DeliveryOutputDto add(DeliveryInputDto deliveryInputDto) {
        Feedback feedback = feedbackService.findByCode(deliveryInputDto.getFeedbackCode());
        Customer customer = customerService.findByEmail(deliveryInputDto.getCustomerEmail());
        Biker biker = bikerService.findByEmail(deliveryInputDto.getBikerEmail());
        Delivery delivery = Delivery.builder()
                .customer(customer)
                .biker(biker)
                .deliveryDate(LocalDateTime.now())
                .build();
        if (Objects.nonNull(feedback)){
            delivery.setFeedback(feedback);
        }
        deliveryRepo.save(delivery);
        return deliveryMapper.deliveryToDto(delivery);
    }
}

package com.snapp.backend_box.service;

import com.snapp.backend_box.dto.request.DeliveryInputDto;
import com.snapp.backend_box.dto.response.DeliveryOutputDto;
import com.snapp.backend_box.model.Delivery;

import java.util.List;
import java.util.Optional;

public interface DeliveryService {
    List<DeliveryOutputDto> getAll();
    Delivery findById(Long id);
    DeliveryOutputDto add(DeliveryInputDto deliveryInputDto);
}

package com.snapp.backend_box.service;

import com.snapp.backend_box.dto.response.DeliveryOutputDto;

import java.util.List;

public interface DeliveryService {
    List<DeliveryOutputDto> getAll();
}

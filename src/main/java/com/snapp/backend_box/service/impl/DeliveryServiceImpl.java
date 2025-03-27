package com.snapp.backend_box.service.impl;


import com.snapp.backend_box.dto.response.DeliveryOutputDto;
import com.snapp.backend_box.repository.DeliveryRepo;
import com.snapp.backend_box.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepo deliveryRepo;

    @Override
    public List<DeliveryOutputDto> getAll() {
        return null;
    }
}

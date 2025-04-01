package com.snapp.backend_box.controller;

import com.snapp.backend_box.dto.response.DeliveryOutputDto;
import com.snapp.backend_box.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/deliverys")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;

    @GetMapping("/all")
    public ResponseEntity<List<DeliveryOutputDto>> getAllDelivery() {
        List<DeliveryOutputDto> all = deliveryService.getAll();
        return ResponseEntity.ok(all);
    }

}

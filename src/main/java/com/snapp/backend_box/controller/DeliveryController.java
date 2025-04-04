package com.snapp.backend_box.controller;

import com.snapp.backend_box.dto.request.DeliveryInputDto;
import com.snapp.backend_box.dto.response.DeliveryOutputDto;
import com.snapp.backend_box.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deliverys")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;

    @PostMapping
    public ResponseEntity<DeliveryOutputDto> add(@RequestBody DeliveryInputDto deliveryInputDto){
        DeliveryOutputDto addedDelivery = deliveryService.add(deliveryInputDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedDelivery);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DeliveryOutputDto>> getAllDelivery() {
        List<DeliveryOutputDto> all = deliveryService.getAll();
        return ResponseEntity.ok(all);
    }

}

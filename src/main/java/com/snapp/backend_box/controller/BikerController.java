package com.snapp.backend_box.controller;


import com.snapp.backend_box.dto.response.BikerOutputDto;
import com.snapp.backend_box.service.BikerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bikers")
@RequiredArgsConstructor
public class BikerController {

    private final BikerService bikerService;

    @GetMapping("/all")
    public ResponseEntity<List<BikerOutputDto>> getAll() {
        return ResponseEntity.ok(bikerService.getAll());
    }
}

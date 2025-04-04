package com.snapp.backend_box.controller;


import com.snapp.backend_box.dto.request.BikerInputDto;
import com.snapp.backend_box.dto.response.BikerOutputDto;
import com.snapp.backend_box.service.BikerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bikers")
@RequiredArgsConstructor
public class BikerController {

    private final BikerService bikerService;

    @PostMapping
    public ResponseEntity<BikerOutputDto> add(@RequestBody @Valid BikerInputDto bikerInputDto){
        BikerOutputDto createdBiker = bikerService.add(bikerInputDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBiker);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BikerOutputDto>> getAll() {
        return ResponseEntity.ok(bikerService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        bikerService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("the biker have been deleted successfully");
    }
}

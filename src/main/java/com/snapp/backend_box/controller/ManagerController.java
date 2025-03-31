package com.snapp.backend_box.controller;


import com.snapp.backend_box.dto.request.ManagerInputDto;
import com.snapp.backend_box.dto.response.ManagerOutputDto;
import com.snapp.backend_box.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;


    @PostMapping
    public ResponseEntity<ManagerOutputDto> add(@RequestBody ManagerInputDto managerInputDto){
        ManagerOutputDto managerOutputDto = managerService.add(managerInputDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(managerOutputDto);
    }
}

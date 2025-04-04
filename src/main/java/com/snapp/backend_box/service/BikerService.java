package com.snapp.backend_box.service;

import com.snapp.backend_box.dto.request.BikerInputDto;
import com.snapp.backend_box.dto.response.BikerOutputDto;
import com.snapp.backend_box.model.Biker;

import java.util.List;

public interface BikerService {

    List<BikerOutputDto> getAll();
    BikerOutputDto add(BikerInputDto bikerInputDto);
    void delete(Long id);
    Biker findByEmail(String email);
}

package com.snapp.backend_box.service;

import com.snapp.backend_box.dto.response.BikerOutputDto;

import java.util.List;

public interface BikerService {

    List<BikerOutputDto> getAll();
}

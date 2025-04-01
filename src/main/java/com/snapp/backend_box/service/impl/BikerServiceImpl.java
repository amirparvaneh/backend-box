package com.snapp.backend_box.service.impl;


import com.snapp.backend_box.dto.response.BikerOutputDto;
import com.snapp.backend_box.mapper.BikerMapper;
import com.snapp.backend_box.model.Biker;
import com.snapp.backend_box.repository.BikerRepo;
import com.snapp.backend_box.service.BikerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BikerServiceImpl implements BikerService {

    private final BikerRepo bikerRepo;
    private final BikerMapper bikerMapper;
    @Override
    public List<BikerOutputDto> getAll() {
        List<Biker> bikers = bikerRepo.findAll();
        return bikerMapper.BikerToDto(bikers);
    }
}

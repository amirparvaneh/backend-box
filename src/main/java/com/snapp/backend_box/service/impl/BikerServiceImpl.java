package com.snapp.backend_box.service.impl;


import com.snapp.backend_box.dto.request.BikerInputDto;
import com.snapp.backend_box.dto.response.BikerOutputDto;
import com.snapp.backend_box.exception.NotFoundException;
import com.snapp.backend_box.mapper.BikerMapper;
import com.snapp.backend_box.model.Biker;
import com.snapp.backend_box.repository.BikerRepo;
import com.snapp.backend_box.service.BikerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @Override
    public BikerOutputDto add(BikerInputDto bikerInputDto) {
        Biker addedBiker = bikerRepo.save(bikerMapper.bikerInputDtoToBiker(bikerInputDto));
        return bikerMapper.bikerToOutputDto(addedBiker);
    }

    @Override
    public void delete(Long id) {
        Biker biker = bikerRepo.findById(id).orElseThrow(()->
                new NotFoundException("this biker is not available", HttpStatus.NOT_FOUND,id));
        bikerRepo.delete(biker);
    }
}

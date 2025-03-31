package com.snapp.backend_box.service.impl;

import com.snapp.backend_box.dto.request.ManagerInputDto;
import com.snapp.backend_box.dto.response.ManagerOutputDto;
import com.snapp.backend_box.mapper.ManagerMapper;
import com.snapp.backend_box.model.Manager;
import com.snapp.backend_box.repository.ManagerRepo;
import com.snapp.backend_box.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepo managerRepo;
    private final ManagerMapper mapper;


    @Override
    public ManagerOutputDto add(ManagerInputDto managerInputDto) {
        Manager manager = mapper.managerInputDtoToManager(managerInputDto);
        return mapper.managerToDto(managerRepo.save(manager));
    }
}

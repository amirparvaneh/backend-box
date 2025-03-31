package com.snapp.backend_box.mapper;


import com.snapp.backend_box.dto.request.ManagerInputDto;
import com.snapp.backend_box.dto.response.ManagerOutputDto;
import com.snapp.backend_box.model.Manager;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ManagerMapper {

    Manager managerInputDtoToManager(ManagerInputDto managerInputDto);
    ManagerOutputDto managerToDto(Manager manager);
}

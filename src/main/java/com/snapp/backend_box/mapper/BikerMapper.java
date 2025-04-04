package com.snapp.backend_box.mapper;


import com.snapp.backend_box.dto.request.BikerInputDto;
import com.snapp.backend_box.dto.response.BikerOutputDto;
import com.snapp.backend_box.model.Biker;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BikerMapper {

    List<BikerOutputDto> BikerToDto(List<Biker> bikers);
    Biker bikerInputDtoToBiker(BikerInputDto bikerInputDto);
    BikerOutputDto bikerToOutputDto(Biker biker);
}

package com.snapp.backend_box.mapper;


import com.snapp.backend_box.dto.response.DeliveryOutputDto;
import com.snapp.backend_box.model.Delivery;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeliveryMapper {
    DeliveryOutputDto deliveryToDto(Delivery delivery);
    List<DeliveryOutputDto> deliveryToListDto(List<Delivery> deliveries);
}

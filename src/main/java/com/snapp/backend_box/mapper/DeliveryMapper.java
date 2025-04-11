package com.snapp.backend_box.mapper;


import com.snapp.backend_box.dto.response.DeliveryOutputDto;
import com.snapp.backend_box.model.Delivery;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeliveryMapper {

    @Mapping(target = "bikerEmail", source = "biker.email")
    @Mapping(target = "customerEmail",source = "customer.email")
    DeliveryOutputDto deliveryToDto(Delivery delivery);
    @InheritConfiguration(name = "deliveryToDto")
    List<DeliveryOutputDto> deliveryToListDto(List<Delivery> deliveries);
}

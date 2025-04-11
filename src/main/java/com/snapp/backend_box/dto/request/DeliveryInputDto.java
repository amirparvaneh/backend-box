package com.snapp.backend_box.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryInputDto implements Serializable {
    private String customerEmail;
    private String bikerEmail;
}

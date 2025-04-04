package com.snapp.backend_box.dto.response;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryOutputDto implements Serializable {
    private String customerEmail;
    private String bikerEmail;
    private String feedbackCode;
    private LocalDateTime deliveryDate;
}

package com.snapp.backend_box.dto.request;


import com.snapp.backend_box.model.Biker;
import com.snapp.backend_box.model.Feedback;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryRequest implements Serializable {
    private LocalDateTime deliveryDate;
    private String customer;
    private Biker biker;
    private Feedback feedback;
}

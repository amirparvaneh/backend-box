package com.snapp.backend_box.dto.response;


import com.snapp.backend_box.model.Biker;
import com.snapp.backend_box.model.Customer;
import com.snapp.backend_box.model.Feedback;
import jakarta.persistence.*;
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
    private LocalDateTime deliveryDate;
}

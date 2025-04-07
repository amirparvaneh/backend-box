package com.snapp.backend_box.dto.request;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeedbackRequest {
    @NotNull(message = "delivery id is required")
    private Long deliveryId;
    @NotNull(message = "this field is mandatory")
    private Integer rating;
    private String comment;
}

package com.snapp.backend_box.dto.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BikerOutputDto implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private Integer averageRating;
}

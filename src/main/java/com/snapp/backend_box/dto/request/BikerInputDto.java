package com.snapp.backend_box.dto.request;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BikerInputDto implements Serializable {
    private String firstName;
    private String lastName;
    @Email
    private String email;
}

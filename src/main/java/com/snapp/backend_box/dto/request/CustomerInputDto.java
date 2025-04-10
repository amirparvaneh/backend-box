package com.snapp.backend_box.dto.request;


import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInputDto implements Serializable {
    private String firstName;
    private String lastName;
    @Email
    private String email;
    private String password;
}

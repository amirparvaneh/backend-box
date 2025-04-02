package com.snapp.backend_box.dto.request;


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
    private String email;
    private String password;
}

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
public class ManagerInputDto implements Serializable {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String role = "ROLE_MANAGER";
}

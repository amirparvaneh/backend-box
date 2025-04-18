package com.snapp.backend_box.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ManagerOutputDto implements Serializable {
    private String firstName;
    private String lastName;
    private String userName;
}

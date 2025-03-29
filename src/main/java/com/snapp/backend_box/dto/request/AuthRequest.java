package com.snapp.backend_box.dto.request;

import com.snapp.backend_box.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest extends BaseDto {
    private String userName;
    private String password;
}

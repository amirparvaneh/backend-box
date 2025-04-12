package com.snapp.backend_box.exception;


import com.snapp.backend_box.global.ErrorResponse;
import org.springframework.http.HttpStatus;

public class CustomerException extends BusinessException {

    public CustomerException(String message, HttpStatus status, String email){
        super(new ErrorResponse(
                "duplicate.entity",
                HttpStatus.BAD_REQUEST,
                email
        ));
    }
}

package com.snapp.backend_box.exception;

import com.snapp.backend_box.global.ErrorResponse;
import org.springframework.http.HttpStatus;

public class NotFoundException extends BusinessException{

    public NotFoundException(String message,HttpStatus httpStatus,Long id){
        super(new ErrorResponse(
                "not.found.entity",
                HttpStatus.NOT_FOUND,
                id
        ));
    }
}

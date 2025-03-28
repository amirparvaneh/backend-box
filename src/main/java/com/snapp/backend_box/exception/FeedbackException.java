package com.snapp.backend_box.exception;

import com.snapp.backend_box.global.ErrorResponse;
import org.springframework.http.HttpStatus;

public class FeedbackException extends BusinessException{

    public FeedbackException(String code){
        super(new ErrorResponse(
                "not.valid.user",
                HttpStatus.BAD_REQUEST,
                code
        ));

    }
}

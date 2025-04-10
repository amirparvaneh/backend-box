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

    public FeedbackException(String message,HttpStatus httpStatus,Integer rate){
        super(new ErrorResponse(
                "not.valid.rate",
                HttpStatus.BAD_REQUEST,
                rate
        ));
    }

    public FeedbackException(String message,HttpStatus httpStatus,String email){
        super(new ErrorResponse(
                "not.authorized.user",
                HttpStatus.BAD_REQUEST,
                email
        ));
    }
}

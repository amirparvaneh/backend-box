package com.snapp.backend_box.exception;


import com.snapp.backend_box.global.ErrorResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BusinessException extends RuntimeException{
    private ErrorResponse errorResponse;

    public BusinessException(ErrorResponse errorResponse){
        super(errorResponse.getMessage());
        this.errorResponse = errorResponse;
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }
}

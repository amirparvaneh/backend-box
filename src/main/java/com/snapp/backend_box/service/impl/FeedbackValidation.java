package com.snapp.backend_box.service.impl;


import com.snapp.backend_box.exception.FeedbackException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class FeedbackValidation {

    public void validateRate(Integer rate){
        if (rate < 1 || rate > 5 ){
            throw new FeedbackException("rate should be in 1-5", HttpStatus.BAD_REQUEST,rate);
        }
    }
}

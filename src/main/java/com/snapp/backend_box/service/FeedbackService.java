package com.snapp.backend_box.service;

import com.snapp.backend_box.dto.response.FeedbackOutput;
import com.snapp.backend_box.model.Feedback;

import java.util.List;

public interface FeedbackService {

    List<FeedbackOutput> getAll();
//    FeedbackOutput save(FeedbackRequest feedbackRequest, String email);
    Feedback findByCode(String code);
}

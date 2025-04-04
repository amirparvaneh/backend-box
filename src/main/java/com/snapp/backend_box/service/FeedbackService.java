package com.snapp.backend_box.service;

import com.snapp.backend_box.dto.response.FeedBackOutput;
import com.snapp.backend_box.model.Feedback;

import java.util.List;

public interface FeedbackService {

    List<FeedBackOutput> getAll();
    Feedback save(Feedback feedback);
    Feedback findByCode(String code);
}

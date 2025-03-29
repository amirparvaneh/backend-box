package com.snapp.backend_box.service;

import com.snapp.backend_box.dto.response.FeedBackOutput;

import java.util.List;

public interface FeedbackService {

    List<FeedBackOutput> getAll();
}

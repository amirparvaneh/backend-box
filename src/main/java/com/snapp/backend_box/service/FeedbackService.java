package com.snapp.backend_box.service;

import com.snapp.backend_box.dto.response.FeedBackOutout;

import java.util.List;

public interface FeedbackService {

    List<FeedBackOutout> getAll();
}

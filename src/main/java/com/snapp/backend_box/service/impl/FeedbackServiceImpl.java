package com.snapp.backend_box.service.impl;


import com.snapp.backend_box.dto.response.FeedBackOutput;
import com.snapp.backend_box.model.Feedback;
import com.snapp.backend_box.repository.FeedbackRepo;
import com.snapp.backend_box.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepo feedbackRepo;

    @Override
    public List<FeedBackOutput> getAll() {
        return null;
    }

    @Override
    public Feedback save(Feedback feedback) {
        return feedbackRepo.save(feedback);
    }
}

package com.snapp.backend_box.service.impl;


import com.snapp.backend_box.dto.response.FeedBackOutput;
import com.snapp.backend_box.exception.NotFoundException;
import com.snapp.backend_box.mapper.FeedbackMapper;
import com.snapp.backend_box.model.Feedback;
import com.snapp.backend_box.repository.FeedbackRepo;
import com.snapp.backend_box.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepo feedbackRepo;
    private final FeedbackMapper feedbackMapper;

    @Override
    public List<FeedBackOutput> getAll() {
        return feedbackMapper.feedbackListToDto(feedbackRepo.findAll());
    }

    @Override
    public Feedback save(Feedback feedback) {
        return feedbackRepo.save(feedback);
    }

    @Override
    public Feedback findByCode(String code) {
        return feedbackRepo.findFeedbackByCode(code).orElseThrow(()->
                new NotFoundException("feedback not found by this code", HttpStatus.NOT_FOUND,code));
    }
}

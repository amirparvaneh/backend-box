package com.snapp.backend_box.service.impl;


import com.snapp.backend_box.dto.request.FeedbackRequest;
import com.snapp.backend_box.dto.response.FeedbackOutput;
import com.snapp.backend_box.exception.NotFoundException;
import com.snapp.backend_box.mapper.FeedbackMapper;
import com.snapp.backend_box.model.Customer;
import com.snapp.backend_box.model.Delivery;
import com.snapp.backend_box.model.Feedback;
import com.snapp.backend_box.repository.FeedbackRepo;
import com.snapp.backend_box.security.JwtUtil;
import com.snapp.backend_box.service.CustomerService;
import com.snapp.backend_box.service.DeliveryService;
import com.snapp.backend_box.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepo feedbackRepo;
    private final FeedbackMapper feedbackMapper;
    private final FeedbackValidation validation;
    private final DeliveryService deliveryService;
    private final CustomerService customerService;
    private final JwtUtil jwtUtil;

    @Override
    public List<FeedbackOutput> getAll() {
        return feedbackMapper.feedbackListToDto(feedbackRepo.findAll());
    }

    @Override
    public FeedbackOutput save(FeedbackRequest feedbackRequest,String authHeader) {
        validation.validateRate(feedbackRequest.getRating());

        Delivery delivery = deliveryService.findById(feedbackRequest.getDeliveryId());

        Feedback feedback = Feedback.builder()
                .rating(feedbackRequest.getRating())
                .submissionDate(LocalDateTime.now())
                .comment(feedbackRequest.getComment() != null ? feedbackRequest.getComment() : null)
                .delivery(delivery)
                .build();
        feedbackRepo.save(feedback);
        return feedbackMapper.feedbackToDto(feedback);
    }

    @Override
    public Feedback findByCode(String code) {
        return feedbackRepo.findFeedbackByCode(code).orElseThrow(()->
                new NotFoundException("feedback not found by this code", HttpStatus.NOT_FOUND,code));
    }
}

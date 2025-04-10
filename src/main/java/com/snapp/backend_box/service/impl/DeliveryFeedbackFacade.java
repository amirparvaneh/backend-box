package com.snapp.backend_box.service.impl;

import com.snapp.backend_box.dto.request.FeedbackRequest;
import com.snapp.backend_box.dto.response.FeedbackOutput;
import com.snapp.backend_box.exception.FeedbackException;
import com.snapp.backend_box.exception.NotFoundException;
import com.snapp.backend_box.mapper.FeedbackMapper;
import com.snapp.backend_box.model.Delivery;
import com.snapp.backend_box.model.Feedback;
import com.snapp.backend_box.repository.DeliveryRepo;
import com.snapp.backend_box.repository.FeedbackRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class DeliveryFeedbackFacade {
    private final FeedbackValidation validation;
    private final DeliveryRepo deliveryRepo;
    private final FeedbackRepo feedbackRepo;
    private final FeedbackMapper feedbackMapper;


    public FeedbackOutput save(FeedbackRequest feedbackRequest, String email) {
        validation.validateRate(feedbackRequest.getRating());
        Delivery delivery = deliveryRepo.findById(feedbackRequest.getDeliveryId()).orElseThrow(() ->
                new NotFoundException("this delivery id is not found",
                        HttpStatus.NOT_FOUND, feedbackRequest.getDeliveryId()));
        if (!delivery.getCustomer().getEmail().equals(email)) {
            throw new FeedbackException("Delivery doesn't belong to customer", HttpStatus.FORBIDDEN,
                    email);
        }
        Feedback feedback = Feedback.builder()
                .rating(feedbackRequest.getRating())
                .submissionDate(LocalDateTime.now())
                .comment(feedbackRequest.getComment() != null ? feedbackRequest.getComment() : null)
                .delivery(delivery)
                .build();
        feedbackRepo.save(feedback);
        return feedbackMapper.feedbackToDto(feedback);
    }
}

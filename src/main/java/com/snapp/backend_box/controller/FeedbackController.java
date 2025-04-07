package com.snapp.backend_box.controller;


import com.snapp.backend_box.dto.request.FeedbackRequest;
import com.snapp.backend_box.dto.response.FeedbackOutput;
import com.snapp.backend_box.model.Customer;
import com.snapp.backend_box.model.Delivery;
import com.snapp.backend_box.security.JwtUtil;
import com.snapp.backend_box.service.CustomerService;
import com.snapp.backend_box.service.DeliveryService;
import com.snapp.backend_box.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
@RequiredArgsConstructor
public class FeedbackController {

    private final FeedbackService feedbackService;
    private final DeliveryService deliveryService;
    private final CustomerService customerService;
    private final JwtUtil jwtUtil;


    @GetMapping("/all")
    public ResponseEntity<List<FeedbackOutput>> getAll() {
        List<FeedbackOutput> all = feedbackService.getAll();
        return ResponseEntity.ok(all);
    }

    @PostMapping("/submit")
    public ResponseEntity<?> submitFeedback(
            @RequestBody FeedbackRequest feedbackRequest,
            @RequestHeader(value = "Authorization", required = false) String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(401).body("JWT token required");
        }
        String token = authHeader.substring(7);
        String email = jwtUtil.extractEmail(token);
        Customer customer = customerService.findByEmail(email);
        if (customer == null || !jwtUtil.validateToken(token, email)) {
            return ResponseEntity.status(401).body("Invalid or expired JWT");
        }
        Delivery delivery = deliveryService.findById(feedbackRequest.getDeliveryId());
        if (!delivery.getCustomer().getEmail().equals(email)) {
            return ResponseEntity.status(403).body("requested delivery is not assigned to you.");
        }
        FeedbackOutput savedFeedback = feedbackService.save(feedbackRequest,authHeader);
        return ResponseEntity.status(201).body(savedFeedback);
    }

}

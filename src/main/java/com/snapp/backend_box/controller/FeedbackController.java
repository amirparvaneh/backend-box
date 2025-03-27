package com.snapp.backend_box.controller;


import com.snapp.backend_box.dto.response.FeedBackOutout;
import com.snapp.backend_box.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/feedback")
@RequiredArgsConstructor
public class FeedbackController {

    private final FeedbackService feedbackService;


    @GetMapping("/all")
    public ResponseEntity<List<FeedBackOutout>> getAll(){
        List<FeedBackOutout> all = feedbackService.getAll();
        return ResponseEntity.ok(all);
    }
}

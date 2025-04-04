package com.snapp.backend_box.mapper;


import com.snapp.backend_box.dto.response.FeedBackOutput;
import com.snapp.backend_box.model.Feedback;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FeedbackMapper {
    List<FeedBackOutput> feedbackListToDto(List<Feedback> feedbacks);
}

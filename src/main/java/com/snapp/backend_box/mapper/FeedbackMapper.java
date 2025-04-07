package com.snapp.backend_box.mapper;


import com.snapp.backend_box.dto.response.FeedbackOutput;
import com.snapp.backend_box.model.Feedback;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FeedbackMapper {
    List<FeedbackOutput> feedbackListToDto(List<Feedback> feedbacks);
    FeedbackOutput feedbackToDto(Feedback feedback);
}

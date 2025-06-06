package com.snapp.backend_box.service;

import com.snapp.backend_box.dto.request.ManagerInputDto;
import com.snapp.backend_box.dto.response.FeedbackOutput;
import com.snapp.backend_box.dto.response.ManagerOutputDto;

import java.time.LocalDateTime;

public interface ManagerService {
    ManagerOutputDto add(ManagerInputDto managerInputDto);
    FeedbackOutput getFeedback(LocalDateTime deliveryDate);
}

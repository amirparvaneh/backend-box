package com.snapp.backend_box.service;

import com.snapp.backend_box.dto.request.ManagerInputDto;
import com.snapp.backend_box.dto.response.ManagerOutputDto;

public interface ManagerService {
    ManagerOutputDto add(ManagerInputDto managerInputDto);
}

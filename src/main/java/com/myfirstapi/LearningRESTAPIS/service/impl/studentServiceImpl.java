package com.myfirstapi.LearningRESTAPIS.service.impl;

import com.myfirstapi.LearningRESTAPIS.dto.StudentDto;
import com.myfirstapi.LearningRESTAPIS.service.studentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentServiceImpl implements studentService {
    @Override
    public List<StudentDto> getAllStudent() {
        return List.of();
    }
}

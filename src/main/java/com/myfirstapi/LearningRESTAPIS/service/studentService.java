package com.myfirstapi.LearningRESTAPIS.service;

import com.myfirstapi.LearningRESTAPIS.dto.StudentDto;

import java.util.List;

public interface studentService {
    List<StudentDto> getAllStudent();
}

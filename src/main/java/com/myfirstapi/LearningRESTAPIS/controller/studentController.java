package com.myfirstapi.LearningRESTAPIS.controller;

import com.myfirstapi.LearningRESTAPIS.dto.StudentDto;
import com.myfirstapi.LearningRESTAPIS.service.studentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class studentController {

    private final studentService studentService;

    @GetMapping("/students")
    public List<StudentDto> getAllStudents(){
        return studentService.getAllStudent();
    }

}

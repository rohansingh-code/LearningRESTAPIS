package com.myfirstapi.LearningRESTAPIS.controller;

import com.myfirstapi.LearningRESTAPIS.dto.StudentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class studentController {

    @GetMapping("/student")
    public StudentDto getStudent(){
        return new StudentDto(4L, "Rohan", "rohan@gmail.com");
    }

}

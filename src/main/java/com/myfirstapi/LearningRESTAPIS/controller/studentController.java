package com.myfirstapi.LearningRESTAPIS.controller;

import com.myfirstapi.LearningRESTAPIS.dto.StudentDto;
import com.myfirstapi.LearningRESTAPIS.service.studentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class studentController {

    private final studentService studentService;

    @GetMapping("/students")
    public ResponseEntity <List<StudentDto>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }
}
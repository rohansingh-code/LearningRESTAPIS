package com.myfirstapi.LearningRESTAPIS.service;

import com.myfirstapi.LearningRESTAPIS.dto.AddStudentRequestDto;
import com.myfirstapi.LearningRESTAPIS.dto.StudentDto;

import java.util.List;

public interface studentService {
    List<StudentDto> getAllStudent();

    StudentDto getStudentById(Long id);

    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudent(Long id);

    StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);
}

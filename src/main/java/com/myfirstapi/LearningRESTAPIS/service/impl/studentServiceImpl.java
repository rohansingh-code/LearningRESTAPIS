package com.myfirstapi.LearningRESTAPIS.service.impl;

import com.myfirstapi.LearningRESTAPIS.dto.StudentDto;
import com.myfirstapi.LearningRESTAPIS.entity.Student;
import com.myfirstapi.LearningRESTAPIS.repository.studentRepository;
import com.myfirstapi.LearningRESTAPIS.service.studentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class studentServiceImpl implements studentService {

    private final studentRepository studentrepository;

    @Override
    public List<StudentDto> getAllStudent() {

        List<Student> students = studentrepository.findAll();

        List<StudentDto> studentDtoList = students.stream()
                .map(student -> new StudentDto(
                        student.getId(),
                        student.getName(),
                        student.getEmail()
                ))
                .toList();

        return studentDtoList;
    }
}
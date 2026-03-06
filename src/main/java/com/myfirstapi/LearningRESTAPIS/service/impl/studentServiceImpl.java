package com.myfirstapi.LearningRESTAPIS.service.impl;

import com.myfirstapi.LearningRESTAPIS.dto.StudentDto;
import com.myfirstapi.LearningRESTAPIS.entity.Student;
import com.myfirstapi.LearningRESTAPIS.repository.studentRepository;
import com.myfirstapi.LearningRESTAPIS.service.studentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class studentServiceImpl implements studentService {

    private final studentRepository studentrepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudent() {

        List<Student> students = studentrepository.findAll();

        return students.stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .toList();
    }

    @Override
    public StudentDto getStudentById(Long id) {

        Student student = studentrepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));

        return modelMapper.map(student, StudentDto.class);
    }
}
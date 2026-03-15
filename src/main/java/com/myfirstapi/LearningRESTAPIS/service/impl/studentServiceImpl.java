package com.myfirstapi.LearningRESTAPIS.service.impl;

import com.myfirstapi.LearningRESTAPIS.dto.AddStudentRequestDto;
import com.myfirstapi.LearningRESTAPIS.dto.StudentDto;
import com.myfirstapi.LearningRESTAPIS.entity.Student;
import com.myfirstapi.LearningRESTAPIS.repository.studentRepository;
import com.myfirstapi.LearningRESTAPIS.service.studentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class studentServiceImpl implements studentService {
    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student = studentrepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));

        updates.forEach((field, value) -> {
            switch (field) {
                case "name"  -> student.setName((String) value);
                case "email" -> student.setEmail((String) value);
                default      -> throw new IllegalArgumentException("Field not supported: " + field);
            }
        });

        return modelMapper.map(studentrepository.save(student), StudentDto.class);
    }

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

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto,Student.class);
        Student student = studentrepository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentrepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("student not find"));
        studentrepository.delete(student);
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student = studentrepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
        modelMapper.map(addStudentRequestDto,student);

        student = studentrepository.save(student);
        StudentDto map = modelMapper.map(student, StudentDto.class);
        return map;
    }
}
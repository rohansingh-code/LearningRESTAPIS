package com.myfirstapi.LearningRESTAPIS.controller;

import com.myfirstapi.LearningRESTAPIS.dto.AddStudentRequestDto;
import com.myfirstapi.LearningRESTAPIS.dto.StudentDto;
import com.myfirstapi.LearningRESTAPIS.service.studentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class studentController {

    private final studentService studentService;

    @GetMapping
    public ResponseEntity <List<StudentDto>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDto));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(
            @PathVariable Long id,
            @RequestBody AddStudentRequestDto addStudentRequestDto) {

        StudentDto updatedStudent = studentService.updateStudent(id, addStudentRequestDto);
        return ResponseEntity.ok(updatedStudent);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<StudentDto> updatePartialStudent(
            @PathVariable Long id,
            @RequestBody Map<String,Object> updates) {

        StudentDto updatedStudent = studentService.updatePartialStudent(id, updates);
        return ResponseEntity.ok(updatedStudent);
    }


}
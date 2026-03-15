package com.myfirstapi.LearningRESTAPIS.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddStudentRequestDto {
    @NotBlank(message = "name cannot be empty")
    private String name;

    @Email
    @NotBlank(message = "name cannot be empty")
    private String email;
}

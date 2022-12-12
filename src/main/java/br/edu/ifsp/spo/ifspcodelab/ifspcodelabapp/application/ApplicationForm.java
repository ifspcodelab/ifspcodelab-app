package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.application;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.validator.constraints.URL;

import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.course.Shift;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ApplicationForm {
    @NotNull
    @NotBlank
    @Size(min = 7, max = 10)
    String registration;

    @NotNull
    @NotBlank
    String name;
    
    @NotNull
    LocalDate birthDate;
    
    @NotNull
    @NotBlank
    String email;
    
    @NotNull
    @NotBlank
    String phone;
    
    @URL
    String github;
    
    @NotNull
    Double ira;
    
    @NotBlank
    String participationInProjects;
    
    @NotBlank
    String praticalExperience;
    
    @NotBlank
    String notes;
    
    @NotNull
    UUID courseId;

    @NotNull
    Shift shift;

    @NotNull
    String period;
}

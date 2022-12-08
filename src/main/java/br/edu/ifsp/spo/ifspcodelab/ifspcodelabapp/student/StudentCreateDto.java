package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.UUID;

@Value
public class StudentCreateDto {
    @NotNull
    @Email
    String email;
    @NotNull
    @NotBlank
    String name;
    @NotNull
    @CPF
    String cpf;
    @NotNull
    @NotBlank
    String rg;
    @NotNull
    @NotBlank
    LocalDate birthDate;
    @NotNull
    @NotBlank
    String registration;
    @NotNull
    UUID courseId;
    @NotNull
    @NotBlank
    String cellphone;
}

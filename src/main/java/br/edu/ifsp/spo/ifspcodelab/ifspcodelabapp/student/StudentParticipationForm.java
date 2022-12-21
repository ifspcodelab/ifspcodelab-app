package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student;

import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.application.Application;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.student_participation.scholarship_participation.BankAccountType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

interface BasicStudentInfo {  }

interface StudentBankingData {  }

@Data
public class StudentParticipationForm {
    @NotNull(groups = BasicStudentInfo.class)
    @Email(groups = BasicStudentInfo.class)
    String email;

    @NotNull(groups = BasicStudentInfo.class)
    @NotBlank(groups = BasicStudentInfo.class)
    String name;

    @NotNull(groups = BasicStudentInfo.class)
    @CPF(groups = BasicStudentInfo.class)
    String cpf;

    @NotNull(groups = BasicStudentInfo.class)
    @NotBlank(groups = BasicStudentInfo.class)
    String rg;

    @NotNull(groups = BasicStudentInfo.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDate;

    @NotNull(groups = BasicStudentInfo.class)
    @NotBlank(groups = BasicStudentInfo.class)
    String registration;

    @NotNull(groups = BasicStudentInfo.class)
    UUID courseId;

    @NotNull(groups = BasicStudentInfo.class)
    @NotBlank(groups = BasicStudentInfo.class)
    String cellphone;

    @NotNull(groups = StudentBankingData.class)
    @NotBlank(groups = StudentBankingData.class)
    String bankName;

    @NotNull(groups = StudentBankingData.class)
    @NotBlank(groups = StudentBankingData.class)
    String bankCode;

    @NotNull(groups = StudentBankingData.class)
    @NotBlank(groups = StudentBankingData.class)
    String bankAgency;

    @NotNull(groups = StudentBankingData.class)
    BankAccountType bankAccountType;

    @NotNull(groups = BasicStudentInfo.class)
    Boolean confirmed;
}

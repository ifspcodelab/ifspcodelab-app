package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.student_participation.scholarship_participation;

import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.student_participation.StudentParticipation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "scholarships_participations")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ScholarshipParticipation {
    @Id
    private UUID id;
    private String bankName;
    private String bankCode;
    private String bankAgency;
    @Enumerated(EnumType.STRING)
    private BankAccountType bankAccountType;
    @OneToOne
    private StudentParticipation studentParticipation;

    public ScholarshipParticipation(String bankName, String bankCode, String bankAgency, BankAccountType bankAccountType, StudentParticipation studentParticipation) {
        this.id = UUID.randomUUID();
        this.bankName = bankName;
        this.bankCode = bankCode;
        this.bankAgency = bankAgency;
        this.bankAccountType = bankAccountType;
        this.studentParticipation = studentParticipation;
    }
}

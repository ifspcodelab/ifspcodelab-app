package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.student_participation;

import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.application.Application;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "students_participations")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentParticipation {
    @Id
    private UUID id;
    @Enumerated(EnumType.STRING)
    private StudentParticipationType studentParticipationType;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Application application;

    public StudentParticipation(
            StudentParticipationType studentParticipationType,
            LocalDate startDate,
            Student student,
            Application application
    ) {
        this.id = UUID.randomUUID();
        this.studentParticipationType = studentParticipationType;
        this.startDate = startDate;
        this.endDate = null;
        this.student = student;
        this.application = application;
    }
}

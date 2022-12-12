package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student_participation;

import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.edition.Edition;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "student_participations")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentParticipation {
    @Id
    private UUID id;
    private LocalDate entryDate;
    private LocalDate departureDate;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Edition edition;

    public StudentParticipation(LocalDate entryDate, LocalDate departureDate, Student student, Edition edition) {
        this.id = UUID.randomUUID();
        this.entryDate = entryDate;
        this.departureDate = departureDate;
        this.student = student;
        this.edition = edition;
    }
}

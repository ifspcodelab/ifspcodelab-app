package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student;

import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.course.Course;
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
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    private UUID id;
    private String name;
    private String cpf;
    private String rg;
    private LocalDate birthDate;
    private String registration;
    @ManyToOne
    private Course course;
    private String cellphone;
}

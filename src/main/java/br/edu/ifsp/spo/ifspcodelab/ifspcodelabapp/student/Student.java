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
    private String email;
    private String name;
    private String cpf;
    private String rg;
    private LocalDate birthDate;
    private String registration;
    @ManyToOne
    private Course course;
    private String cellphone;

    public Student(String email, String name, String cpf, String rg, LocalDate birthDate, String registration, Course course, String cellphone) {
        this.id = UUID.randomUUID();
        this.email = email;
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.birthDate = birthDate;
        this.registration = registration;
        this.course = course;
        this.cellphone = cellphone;
    }
}

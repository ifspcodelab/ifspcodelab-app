package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.application;

import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.selection.Selection;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.course.Course;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.course.Shift;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "applications")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Application {
    @Id
    private UUID id;
    private LocalDate createdAt;
    private String registration;
    private String name;
    private LocalDate birthDate;
    private String email;
    private String phone;
    private String github;
    private Double ira;
    private String participationInProjects;
    private String praticalExperience;
    private String notes;
    @ManyToOne
    private Course course;
    @Enumerated(EnumType.STRING)
    private Shift shift;
    private String period;
    @ManyToOne
    private Selection selection;
    private Integer points;
    private Boolean selected;
    
    public Application(LocalDate createdAt, String registration, String name, LocalDate birthDate, String email,
            String phone, String github, Double ira, String participationInProjects, String praticalExperience,
            String notes, Course course, Shift shift, String period, Selection selection, Integer points,
            Boolean selected) {
        this.id = UUID.randomUUID();
        this.createdAt = createdAt;
        this.registration = registration;
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
        this.github = github;
        this.ira = ira;
        this.participationInProjects = participationInProjects;
        this.praticalExperience = praticalExperience;
        this.notes = notes;
        this.course = course;
        this.shift = shift;
        this.period = period;
        this.selection = selection;
        this.points = points;
        this.selected = selected;
    } 
}
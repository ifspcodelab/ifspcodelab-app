package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.course;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Shift {
    MORNING("Matutino"), 
    EVENING("Vespertino"), 
    NIGHT("Noturno");

    private String name;
}

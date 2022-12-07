package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.edition;

import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.project.Project;
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
@Table(name = "subevents")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Edition {
    @Id
    private UUID id;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToOne
    private Project project;
}

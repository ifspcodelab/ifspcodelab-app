package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.selection;

import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.edition.Edition;
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
@Table(name = "selections")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Selection {
    @Id
    private UUID id;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToOne
    private Edition edition;

    public Selection(LocalDate startDate, LocalDate endDate, Edition edition){
        this.id = UUID.randomUUID();
        this.startDate = startDate;
        this.endDate = endDate;
        this.edition = edition;
    }
}

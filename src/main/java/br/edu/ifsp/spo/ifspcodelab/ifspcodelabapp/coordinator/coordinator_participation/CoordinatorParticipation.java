package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.coordinator.coordinator_participation;

import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.coordinator.Coordinator;
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
@Table(name = "coordinators_participations")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CoordinatorParticipation {
    @Id
    private UUID id;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToOne
    private Coordinator coordinator;
    @ManyToOne
    private Edition edition;

    public CoordinatorParticipation(LocalDate startDate, LocalDate endDate, Coordinator coordinator, Edition edition) {
        this.id = UUID.randomUUID();
        this.startDate = startDate;
        this.endDate = endDate;
        this.coordinator = coordinator;
        this.edition = edition;
    }
}

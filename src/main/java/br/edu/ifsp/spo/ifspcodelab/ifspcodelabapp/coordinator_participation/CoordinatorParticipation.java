package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.coordinator_participation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "coordinator_participations")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CoordinatorParticipation {
    @Id
    private UUID id;
    private LocalDate entryDate;
    private LocalDate departureDate;
}

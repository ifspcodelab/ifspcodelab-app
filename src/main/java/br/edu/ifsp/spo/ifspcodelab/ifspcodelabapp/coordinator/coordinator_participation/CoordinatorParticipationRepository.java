package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.coordinator.coordinator_participation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CoordinatorParticipationRepository extends JpaRepository<CoordinatorParticipation, UUID> {
}

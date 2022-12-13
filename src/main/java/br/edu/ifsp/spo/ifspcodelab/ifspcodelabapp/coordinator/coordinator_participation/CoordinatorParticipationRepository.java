package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.coordinator_participation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CoordinatorParticipationRepository  extends JpaRepository<CoordinatorParticipation, UUID> {
    List<CoordinatorParticipation> findAllByCoordinatorEmail(String email);
}

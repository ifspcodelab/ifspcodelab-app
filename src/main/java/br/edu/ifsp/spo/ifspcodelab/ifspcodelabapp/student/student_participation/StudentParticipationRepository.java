package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.student_participation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentParticipationRepository extends JpaRepository<StudentParticipation, UUID> {
    boolean existsByApplicationId(UUID applicationId);
}

package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.student_participation.scholarship_participation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScholarshipParticipationRepository extends JpaRepository<ScholarshipParticipation, UUID> {
}

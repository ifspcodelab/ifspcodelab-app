package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.coordinator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CoordinatorRepository extends JpaRepository<Coordinator, UUID> {
}

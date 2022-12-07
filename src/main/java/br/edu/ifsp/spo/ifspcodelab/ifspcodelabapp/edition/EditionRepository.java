package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.edition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EditionRepository  extends JpaRepository<Edition, UUID> {
}

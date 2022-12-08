package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.selection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SelectionRepository  extends JpaRepository<Selection, UUID> {
}
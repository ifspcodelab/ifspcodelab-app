package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.coordinator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "coordinator")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Coordinator {
    @Id
    private UUID id;
    private String name;
    private String email;
    private String registration;
    private String department;
}

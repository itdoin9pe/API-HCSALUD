package com.saludSystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tipos_paciente")
public class TipoPaciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int tipoPacienteId;

    @Column(name = "nombres", nullable = false)
    public String nombre;

}

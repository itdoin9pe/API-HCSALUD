package com.saludSystem.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "informacion_clinicas")
public class InformacionClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID informacionClinicaId;

    @NotBlank
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "estado", nullable = false)
    private Integer estado;

}

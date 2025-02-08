package com.saludSystem.entities;

import com.saludSystem.entities.configuracion.SysSalud;
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
@Table(name = "aseguradoras")
public class Aseguradora {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_aseguradora", nullable = false, unique = true)
    private UUID id;

    @NotBlank
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "estado", nullable = false)
    private Integer estado;

}
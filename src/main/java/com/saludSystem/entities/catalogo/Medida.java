package com.saludSystem.entities.catalogo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medidas")
public class Medida {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_medida", nullable = false, unique = true)
    private UUID medidaId;

    @Column(name = "nombres")
    private String nombre;

    @NotNull
    @Column(name = "estado", nullable = false)
    private Integer estado;
}

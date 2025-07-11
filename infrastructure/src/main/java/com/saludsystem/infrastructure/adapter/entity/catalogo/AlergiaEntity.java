package com.saludsystem.infrastructure.adapter.entity.catalogo;

import com.saludsystem.infrastructure.adapter.entity.configuracion.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "alergias")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AlergiaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID alergiaId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "estado", nullable = false)
    private Integer estado;

}
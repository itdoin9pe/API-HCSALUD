package com.saludsystem.submodules.core.operaciones.adapter.entity;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "unidades")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class UnidadEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "unidad_id", nullable = false)
    private UUID unidadId;

    @Column(name = "nombre_unidad", nullable = false)
    private String nombre;

    @Column(name = "siglas_unidad", nullable = false)
    private String siglas;

    @Column(name = "descripcion_unidad", nullable = false)
    private String descripcion;

    @Column(name = "estado_unidad", nullable = false)
    private Integer estado;

}
package com.saludsystem.submodules.sections.mantenimiento.adapter.entity;

import com.saludsystem.submodules.sections.configuracion.adapter.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "enfermedades")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class EnfermedadEntity extends BaseEntity {

    @Id
    @Column(name = "enfermedad_id", nullable = false)
    private String enfermedadId;

    @Column(name = "descripcion_enfermedad", nullable = false)
    private String descripcion;

    @Column(name = "estado_enfermedad", nullable = false)
    private Integer estado;

}
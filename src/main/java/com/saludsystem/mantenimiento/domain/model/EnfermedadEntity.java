package com.saludsystem.mantenimiento.domain.model;

import com.saludsystem.shared.domain.model.BaseEntity;
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
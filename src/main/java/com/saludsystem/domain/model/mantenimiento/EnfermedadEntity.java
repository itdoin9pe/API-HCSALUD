package com.saludsystem.domain.model.mantenimiento;

import com.saludsystem.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "enfermedades")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EnfermedadEntity extends BaseEntity {

    @Id
    @Column(name = "enfermedad_id", nullable = false)
    private String enfermedadId;

    @Column(name = "descripcion_enfermedad", nullable = false)
    private String descripcion;

    @Column(name = "estado_enfermedad", nullable = false)
    private Integer estado;

}
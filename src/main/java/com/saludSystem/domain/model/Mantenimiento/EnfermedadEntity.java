package com.saludSystem.domain.model.Mantenimiento;

import com.saludSystem.domain.model.BaseEntity;
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
    private String enfermedadId;

    @Column(name = "descripcion_enfermedad", nullable = false)
    private String descripcion;

    @Column(name = "estado_enfermedad", nullable = false)
    private Integer estado;

}
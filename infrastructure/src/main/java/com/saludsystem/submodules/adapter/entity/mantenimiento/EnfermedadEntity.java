package com.saludsystem.submodules.adapter.entity.mantenimiento;

import com.saludsystem.submodules.adapter.entity.configuracion.BaseEntity;
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
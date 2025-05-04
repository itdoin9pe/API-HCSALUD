package com.saludSystem.domain.model.Principal;

import com.saludSystem.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "departamentos")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class DepartamentoEntity extends BaseEntity {

    @Id
    @Column(name = "departamento_id", nullable = false)
    private String departamentoId;

    @Column(name = "nombre_departamento", nullable = false)
    private String nombre;

    @Column(name = "estado_departamento", nullable = false)
    private Integer estado;

}
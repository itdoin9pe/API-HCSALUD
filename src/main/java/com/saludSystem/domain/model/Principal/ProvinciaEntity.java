package com.saludSystem.domain.model.Principal;

import com.saludSystem.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "provincias")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ProvinciaEntity extends BaseEntity {

    @Id
    @Column(name = "provincia_id", nullable = false)
    private String provinciaId;

    @Column(name = "nombre_provincia", nullable = false)
    private String nombre;

    @Column(name = "estado_provincia", nullable = false)
    private Integer estado;

    @ManyToOne
    @JoinColumn(name = "departamento_id", referencedColumnName = "departamento_id", nullable = false)
    private DepartamentoEntity departamento;

}
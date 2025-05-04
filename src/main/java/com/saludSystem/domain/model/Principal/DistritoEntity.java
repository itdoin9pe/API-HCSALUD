package com.saludSystem.domain.model.Principal;

import com.saludSystem.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "distritos")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class DistritoEntity extends BaseEntity {

    @Id
    @Column(name = "distrito_id", nullable = false)
    private String distritoId;

    @Column(name = "nombre_distrito", nullable = false)
    private String nombre;

    @Column(name = "estado_distrito", nullable = false)
    private Integer estado;

    @ManyToOne
    @JoinColumn(name = "provincia_id", referencedColumnName = "provincia_id", nullable = false)
    private ProvinciaEntity provincia;

}
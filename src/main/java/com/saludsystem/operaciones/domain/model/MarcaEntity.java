package com.saludsystem.operaciones.domain.model;

import com.saludsystem.shared.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "marcas_materiales")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class MarcaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "marcaMateriales_id", nullable = false)
    private UUID marcaMaterialesId;

    @Column(name = "nombre_marca", nullable = false)
    private String nombre;

    @Column(name = "estado_marca", nullable = false)
    private Integer estado;

}
package com.saludsystem.submodules.core.mantenimiento.adapter.entity;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "tipos_gasto")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class TipoGastoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "conceptoGastoId", nullable = false)
    private UUID conceptoGastoId;

    @Column(name = "descripcion_gasto", nullable = false, unique = true)
    private String nombre;

    @Column(name = "estado_gastos", nullable = false)
    private Integer estado;

}
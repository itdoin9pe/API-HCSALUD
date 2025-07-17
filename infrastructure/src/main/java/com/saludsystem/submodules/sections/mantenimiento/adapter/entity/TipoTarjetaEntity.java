package com.saludsystem.submodules.sections.mantenimiento.adapter.entity;

import com.saludsystem.submodules.sections.configuracion.adapter.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "tipos_tarjetas")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class TipoTarjetaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "tipoTarjetaId", nullable = false)
    private UUID tipoTarjetaId;

    @Column(name = "descripcion_tipoTarjeta", nullable = false)
    private String descripcion;

    @Column(name = "estado_tipoTarjeta", nullable = false)
    private Integer estado;

}
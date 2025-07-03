package com.saludsystem.domain.model.mantenimiento;

import com.saludsystem.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tipos_tarjetas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
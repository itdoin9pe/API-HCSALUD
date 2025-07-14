package com.saludsystem.submodules.adapter.entity.mantenimiento;

import com.saludsystem.submodules.adapter.entity.configuracion.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "monedas")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class MonedaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID monedaId;

    @Column(name = "descripcion_moneda", nullable = false)
    private String descripcion;

    @Column(name = "estado_moneda", nullable = false)
    private Integer estado;

}
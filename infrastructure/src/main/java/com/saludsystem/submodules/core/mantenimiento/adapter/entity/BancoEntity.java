package com.saludsystem.submodules.core.mantenimiento.adapter.entity;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "bancos")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class BancoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "banco_id", nullable = false)
    private UUID bancoId;

    @Column(name = "descripcion_banco", nullable = false, unique = true)
    private String descripcion;

    @Column(name = "estado_banco", nullable = false)
    private Integer estado;

}
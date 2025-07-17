package com.saludsystem.submodules.sections.operaciones.adapter.entity;

import com.saludsystem.submodules.sections.configuracion.adapter.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "presentaciones")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class PresentacionEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "presentacion_id", nullable = false)
    private UUID presentacionId;

    @Column(name = "nombre_presentacion", nullable = false)
    private String nombre;

    @Column(name = "estado_presentacion", nullable = false)
    private Integer estado;

}
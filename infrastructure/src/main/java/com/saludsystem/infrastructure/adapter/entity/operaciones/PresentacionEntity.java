package com.saludsystem.infrastructure.adapter.entity.operaciones;

import com.saludsystem.infrastructure.adapter.entity.configuracion.BaseEntity;
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
package com.saludsystem.submodules.sections.catalogo.adapter.entity;

import com.saludsystem.submodules.sections.configuracion.adapter.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tipo_citado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TipoCitadoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "tipoCitadoId", nullable = false)
    private UUID tipoCitadoId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "estado", nullable = false)
    private Integer estado;

}

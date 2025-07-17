package com.saludsystem.submodules.sections.catalogo.adapter.entity;

import com.saludsystem.submodules.sections.configuracion.adapter.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "apoderados")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApoderadoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "apoderado_id", nullable = false)
    private UUID apoderadoId;

    @Column(name = "nombre_apoderado", nullable = false)
    private String nombre;

    @Column(name = "nroDocumento_apoderado", nullable = false, unique = true)
    private String nroDocumento;

    @Column(name = "direccion_apoderado", nullable = false)
    private String direccion;

    @Column(name = "telefono_apoderado", unique = true)
    private String telefono;

    @Column(name = "estado_apoderado", nullable = false)
    private Integer estado;

}
package com.saludsystem.submodules.core.operaciones.adapter.entity;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "tipos_materiales")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class TipoMaterialEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "tipoMaterial_id", nullable = false)
    private UUID tipoMaterialId;

    @Column(name = "nombre_tipoMaterial", nullable = false)
    private String nombre;

    @Column(name = "descripcion_tipoMaterial", nullable = false)
    private String descripcion;

    @Column(name = "estado_tipoMaterial", nullable = false)
    private Integer estado;

}
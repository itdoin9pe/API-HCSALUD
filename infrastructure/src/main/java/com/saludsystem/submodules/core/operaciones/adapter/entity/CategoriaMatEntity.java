package com.saludsystem.submodules.core.operaciones.adapter.entity;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "categoria")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class CategoriaMatEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "categoriaMaterial_id", nullable = false)
    private UUID categoriaMaterialId;

    @Column(name = "nombre_categoria", nullable = false)
    private String nombre;

    @Column(name = "descripcion_categoria", nullable = false)
    private String descripcion;

    @Column(name = "estado_categoria", nullable = false)
    private Integer estado;

}
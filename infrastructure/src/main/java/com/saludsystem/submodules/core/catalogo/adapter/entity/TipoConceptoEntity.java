package com.saludsystem.submodules.core.catalogo.adapter.entity;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tipo_concepto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TipoConceptoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "tipo_conceptoId", nullable = false)
    private UUID tipoConceptoId;

    @Column(name = "nombre_tipoConcepto", nullable = false)
    private String nombre;

    @Column(name = "estado_tipoConcepto", nullable = false)
    private Integer estado;

}
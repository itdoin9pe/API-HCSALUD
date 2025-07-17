package com.saludsystem.submodules.sections.mantenimiento.adapter.entity;

import com.saludsystem.submodules.sections.catalogo.adapter.entity.CategoriaEntity;
import com.saludsystem.submodules.sections.catalogo.adapter.entity.MedidaEntity;
import com.saludsystem.submodules.sections.catalogo.adapter.entity.TipoConceptoEntity;
import com.saludsystem.submodules.sections.configuracion.adapter.entity.BaseEntity;
import com.saludsystem.submodules.sections.operaciones.adapter.entity.UnidadEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "tarifarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class TarifarioEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "tarifario_id", nullable = false)
    private UUID tarifarioId;

    @ManyToOne
    @JoinColumn(name = "tipoConcepto_id", nullable = false)
    private TipoConceptoEntity tipoConceptoEntity;

    @ManyToOne
    @JoinColumn(name = "medida_id", nullable = false)
    private MedidaEntity medidaEntity;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private CategoriaEntity categoriaEntity;

    @ManyToOne
    @JoinColumn(name = "unidad_id", nullable = false)
    private UnidadEntity unidadEntity;

    @Column(name = "grupo", nullable = false)
    private String grupo;

    @Column(name = "descripcion_tarifario", nullable = false)
    private String descripcion;

    @Column(name = "precio_tarifario", nullable = false)
    private Double precio;

    @Column(name = "estado_tarifario", nullable = false)
    private Integer estado;

}
package com.saludsystem.infrastructure.adapter.entity.mantenimiento;

import com.saludsystem.infrastructure.adapter.entity.catalogo.CategoriaEntity;
import com.saludsystem.infrastructure.adapter.entity.catalogo.MedidaEntity;
import com.saludsystem.infrastructure.adapter.entity.catalogo.TipoConceptoEntity;
import com.saludsystem.infrastructure.adapter.entity.configuracion.BaseEntity;
import com.saludsystem.infrastructure.adapter.entity.operaciones.UnidadEntity;
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
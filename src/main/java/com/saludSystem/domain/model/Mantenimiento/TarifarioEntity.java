package com.saludSystem.domain.model.Mantenimiento;

import com.saludSystem.domain.model.BaseEntity;
import com.saludSystem.domain.model.Catalogo.CategoriaEntity;
import com.saludSystem.domain.model.Catalogo.MedidaEntity;
import com.saludSystem.domain.model.Catalogo.TipoConceptoEntity;
import com.saludSystem.domain.model.Operaciones.UnidadEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tarifarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
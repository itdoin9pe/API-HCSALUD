package com.saludSystem.Mantenimiento.Tarifario.dominio;

import com.saludSystem.Catalogo.Categoria.dominio.CategoriaModel;
import com.saludSystem.Catalogo.Medida.dominio.MedidaModel;
import com.saludSystem.Catalogo.TipoConcepto.dominio.TipoConceptoModel;
import com.saludSystem.Generals.adapter.BaseEntity;
import com.saludSystem.Operaciones.Unidad.dominio.UnidadModel;
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
public class TarifarioModel extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "tarifario_id", nullable = false)
    private UUID tarifarioId;

    @ManyToOne
    @JoinColumn(name = "tipoConcepto_id", nullable = false)
    private TipoConceptoModel tipoConceptoModel;

    @ManyToOne
    @JoinColumn(name = "medida_id", nullable = false)
    private MedidaModel medidaModel;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private CategoriaModel categoriaModel;

    @ManyToOne
    @JoinColumn(name = "unidad_id", nullable = false)
    private UnidadModel unidadModel;

    @Column(name = "grupo", nullable = false)
    private String grupo;

    @Column(name = "descripcion_tarifario", nullable = false)
    private String descripcion;

    @Column(name = "precio_tarifario", nullable = false)
    private Double precio;

    @Column(name = "estado_tarifario", nullable = false)
    private Integer estado;

}
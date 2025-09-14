package com.saludsystem.submodules.core.mantenimiento.adapter.entity;

import java.util.UUID;

import com.saludsystem.submodules.core.catalogo.adapter.entity.CategoriaEntity;
import com.saludsystem.submodules.core.catalogo.adapter.entity.MedidaEntity;
import com.saludsystem.submodules.core.catalogo.adapter.entity.TipoConceptoEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;
import com.saludsystem.submodules.core.operaciones.adapter.entity.UnidadEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tarifarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class TarifarioEntity extends BaseEntity
{
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
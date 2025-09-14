package com.saludsystem.submodules.core.operaciones.adapter.entity;

import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "unidades")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class UnidadEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "unidad_id", nullable = false)
	private UUID unidadId;

	@Column(name = "nombre_unidad", nullable = false)
	private String nombre;

	@Column(name = "siglas_unidad", nullable = false)
	private String siglas;

	@Column(name = "descripcion_unidad", nullable = false)
	private String descripcion;

	@Column(name = "estado_unidad", nullable = false)
	private Integer estado;
}
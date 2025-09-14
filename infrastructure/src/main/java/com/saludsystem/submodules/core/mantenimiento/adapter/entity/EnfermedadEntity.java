package com.saludsystem.submodules.core.mantenimiento.adapter.entity;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "enfermedades")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class EnfermedadEntity extends BaseEntity
{
	@Id
	@Column(name = "enfermedad_id", nullable = false)
	private String enfermedadId;

	@Column(name = "descripcion_enfermedad", nullable = false)
	private String descripcion;

	@Column(name = "estado_enfermedad", nullable = false)
	private Integer estado;
}
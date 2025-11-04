package com.saludsystem.submodules.core.catalogo.adapter.entity;

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

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tipo_concepto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TipoConceptoEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "tipo_conceptoId", nullable = false)
	private UUID tipoConceptoId;

	@Column(name = "nombre_tipoConcepto", nullable = false)
	private String nombre;

	@Column(name = "estado_tipoConcepto", nullable = false)
	private Integer estado;
}
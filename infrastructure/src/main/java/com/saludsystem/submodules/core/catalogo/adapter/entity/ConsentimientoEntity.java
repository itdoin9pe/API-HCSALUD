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
@Table(name = "consentimientos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ConsentimientoEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "consentimiento_id", nullable = false)
	private UUID consentimientoId;

	@Column(name = "nombre_consentimiento", nullable = false)
	private String nombre;

	@Column(name = "observacion_consentimiento", nullable = false)
	private String observacion;

	@Column(name = "estado_consentimiento", nullable = false)
	private Integer estado;

	@Column(name = "texto_consentimiento", nullable = false)
	private String texto;
}
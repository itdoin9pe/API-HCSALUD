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
@Table(name = "apoderados")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApoderadoEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "apoderado_id", nullable = false)
	private UUID apoderadoId;

	@Column(name = "nombre_apoderado", nullable = false)
	private String nombre;

	@Column(name = "tipo_documento", nullable = false)
	private String tipoDocumento;

	@Column(name = "nroDocumento_apoderado", nullable = false, unique = true)
	private String nroDocumento;

	@Column(name = "direccion_apoderado", nullable = false)
	private String direccion;

	@Column(name = "telefono_apoderado", unique = true)
	private String telefono;

	@Column(name = "estado_apoderado", nullable = false)
	private Integer estado;
}
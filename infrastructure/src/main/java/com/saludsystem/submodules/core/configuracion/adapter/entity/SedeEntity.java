package com.saludsystem.submodules.core.configuracion.adapter.entity;

import java.util.UUID;

import com.saludsystem.submodules.core.principal.adapter.entity.SucursalEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sedes")
public class SedeEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id_sede", nullable = false, unique = true)
	private UUID sedeId;

	@NotBlank
	@Column(name = "codigo", nullable = false)
	private String codigo;

	@NotBlank
	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "ubigeo")
	private String ubigeo;

	@Column(name = "estado", nullable = false)
	private Integer estado;

	@ManyToOne
	@JoinColumn(name = "sucursal_id", nullable = false)
	private SucursalEntity sucursalEntity;
}
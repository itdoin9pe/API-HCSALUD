package com.saludsystem.submodules.core.movimiento.adapter.entity;

import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SedeEntity;
import com.saludsystem.submodules.core.principal.adapter.entity.SucursalEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "almacenes")
@EqualsAndHashCode(callSuper = true)
public class AlmacenEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "almacen_id", nullable = false, unique = true)
	private UUID almacenId;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "estado", nullable = false)
	private Integer estado;

	@ManyToOne
	@JoinColumn(name = "id_sede", nullable = false)
	private SedeEntity sedeEntity;

	@ManyToOne
	@JoinColumn(name = "sucursal_id", nullable = false)
	private SucursalEntity sucursalEntity;
}

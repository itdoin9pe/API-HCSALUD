package com.saludsystem.submodules.core.mantenimiento.adapter.entity;

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
@Table(name = "cajas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class CajaEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "caja_id", nullable = false)
	private UUID cajaId;

	@Column(name = "nombre_caja", nullable = false, unique = true)
	private String nombre;

	@Column(name = "estado_caja", nullable = false)
	private Integer estado;
}
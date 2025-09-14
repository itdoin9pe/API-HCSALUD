package com.saludsystem.submodules.core.principal.adapter.entity;

import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "aseguradoras")
@EqualsAndHashCode(callSuper = true)
public class AseguradoraEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id_aseguradora", nullable = false)
	private UUID aseguradoraId;

	@NotBlank
	@Column(name = "descripcion", nullable = false)
	private String descripcion;

	@Column(name = "estado", nullable = false)
	private Integer estado;
}
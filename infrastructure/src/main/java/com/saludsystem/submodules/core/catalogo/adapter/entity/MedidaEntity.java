package com.saludsystem.submodules.core.catalogo.adapter.entity;

import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "medidas")
public class MedidaEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id_medida", nullable = false)
	private UUID medidaId;

	@Column(name = "nombres")
	private String nombre;

	@NotNull
	@Column(name = "estado", nullable = false)
	private Integer estado;
}
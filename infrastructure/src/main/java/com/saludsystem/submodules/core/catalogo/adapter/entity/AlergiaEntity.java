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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "alergias")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AlergiaEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID alergiaId;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "estado", nullable = false)
	private Integer estado;
}
package com.saludsystem.submodules.core.principal.adapter.entity;

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
@Table(name = "paises")
@EqualsAndHashCode(callSuper = true)
public class PaisEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pais", nullable = false, unique = true)
	private Integer id;

	@NotBlank(message = "this field cant be empty")
	@Column(name = "iso", nullable = false)
	private String iso;

	@NotBlank(message = "this field cant be empty")
	@Column(name = "nombre", nullable = false)
	private String nombre;

	@NotBlank(message = "this field cant be empty")
	@Column(name = "gentilicio")
	private String gentilicio;

	@Column(name = "orden")
	private Integer orden;
}

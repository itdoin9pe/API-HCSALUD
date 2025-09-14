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
@Table(name = "medicamentos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MedicamentoEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "medicamento_id", nullable = false)
	private UUID medicamentoId;

	@Column(name = "medicamento_nombre", nullable = false, unique = true)
	private String nombre;

	@Column(name = "forma_medicamento")
	private String formaFarmaceutica; // Ej: "Tableta", "Jarabe"

	@Column(name = "concentracion_medicamento")
	private String concentracion; // Ej: "500 mg"

	@Column(name = "contenido_medicamento")
	private String contenido; // Ej: "Caja con 10 tabletas"

	@Column(name = "estado_medicamento")
	private Integer estado;
}
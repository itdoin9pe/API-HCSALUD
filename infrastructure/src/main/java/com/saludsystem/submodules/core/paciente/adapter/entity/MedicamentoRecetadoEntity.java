package com.saludsystem.submodules.core.paciente.adapter.entity;

import java.util.UUID;

import com.saludsystem.submodules.core.catalogo.adapter.entity.MedicamentoEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pacientes_medicamentos_recetados")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class MedicamentoRecetadoEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "receta_id", nullable = false)
	private RecetaEntity recetaEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "medicamento_id", nullable = false)
	private MedicamentoEntity medicamentoEntity;

	@Column(nullable = false)
	private String dosis; // ej: "500 mg/400 mg"

	@Column(nullable = false)
	private String frecuencia; // ej: "3 o 2 veces al día"

	@Column(nullable = true)
	private Integer duracionDias; // duración en días / 24 horas

	@Column(length = 500)
	private String indicaciones; // indicaciones adicionales - Opcional
}
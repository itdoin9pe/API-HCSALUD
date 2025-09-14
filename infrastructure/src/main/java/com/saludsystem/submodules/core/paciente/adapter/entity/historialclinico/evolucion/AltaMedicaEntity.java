package com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.evolucion;

import java.time.LocalDateTime;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pacientes_evoluciones_altas_medicas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class AltaMedicaEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alta_medica_id", nullable = false)
	private Long id;

	@Column(name = "alta_medida_fecha", nullable = false)
	private LocalDateTime fecha;

	@Column(name = "alta_medica_resument_final", nullable = false)
	private String resumenFinal;

	@OneToOne
	@JoinColumn(name = "paciente_evolucion_id")
	private EvolucionEntity evolucionEntity;
}
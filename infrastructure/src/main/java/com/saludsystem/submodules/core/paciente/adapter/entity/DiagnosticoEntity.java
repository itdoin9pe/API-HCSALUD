package com.saludsystem.submodules.core.paciente.adapter.entity;

import java.time.LocalDate;
import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;
import com.saludsystem.submodules.core.mantenimiento.adapter.entity.EnfermedadEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "pacientes_diagnosticos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class DiagnosticoEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "paciente_diagnosticos_id", nullable = false)
	private UUID pacienteDiagnosticoId;

	@ManyToOne
	@JoinColumn(name = "id_paciente")
	private PacienteEntity pacienteEntity;

	@ManyToOne
	@JoinColumn(name = "enfermedad_id", nullable = false)
	private EnfermedadEntity enfermedadEntity;

	@Column(name = "fecha_diagnostico", nullable = false)
	private LocalDate fecha;

	@Column(name = "descripcion_diagnostico", nullable = false)
	private String descripcion;
}
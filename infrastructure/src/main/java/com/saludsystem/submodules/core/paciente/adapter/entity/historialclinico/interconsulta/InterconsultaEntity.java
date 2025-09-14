package com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.interconsulta;

import java.time.LocalDateTime;
import java.util.UUID;

import com.saludsystem.submodules.core.catalogo.adapter.entity.EspecialidadEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;
import com.saludsystem.submodules.core.medico.adapter.entity.DoctorEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.PacienteEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "pacientes_interconsultas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InterconsultaEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id_interconsulta", nullable = false)
	private UUID pacienteInterconsultaId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_paciente", nullable = false)
	private PacienteEntity pacienteEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_doctor", nullable = false)
	private DoctorEntity medicoSolicitante; // medico solicitante y destino

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_especialidad", nullable = false)
	private EspecialidadEntity especialidadDestino;

	@Column(nullable = false, length = 500)
	private String motivo;

	@Column(nullable = false)
	private LocalDateTime fechaSolicitud;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private EstadoInterconsulta estado;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private PrioridadInterconsulta prioridad;

	@Column(columnDefinition = "TEXT")
	private String observaciones;

	private LocalDateTime fechaAtencion;
}
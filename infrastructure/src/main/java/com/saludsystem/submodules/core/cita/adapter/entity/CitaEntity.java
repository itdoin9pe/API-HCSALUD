package com.saludsystem.submodules.core.cita.adapter.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import com.saludsystem.submodules.core.catalogo.adapter.entity.EspecialidadEntity;
import com.saludsystem.submodules.core.catalogo.adapter.entity.TipoCitadoEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SedeEntity;
import com.saludsystem.submodules.core.medico.adapter.entity.DoctorEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.PacienteEntity;

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

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "citas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CitaEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id_cita", nullable = false)
	private UUID citadoId;

	@ManyToOne
	@JoinColumn(name = "id_especialidad", nullable = false)
	private EspecialidadEntity especialidadEntity;

	@ManyToOne
	@JoinColumn(name = "id_doctor", nullable = false)
	private DoctorEntity doctorEntity;

	@Column(name = "fecha_cita", nullable = false)
	private LocalDate fecha;

	@Column(name = "hora_inicio", nullable = false)
	private LocalTime horaInicio;

	@Column(name = "hora_fin", nullable = false)
	private LocalTime horaFin;

	@ManyToOne
	@JoinColumn(name = "id_paciente", nullable = false)
	private PacienteEntity pacienteEntity;

	@ManyToOne
	@JoinColumn(name = "id_sede", nullable = false)
	private SedeEntity sedeEntity;

	@ManyToOne
	@JoinColumn(name = "tipoCitadoId", nullable = false)
	private TipoCitadoEntity tipoCitadoEntity;

	@Column(name = "estado_cita", nullable = false)
	private String estado;

	@Column(name = "motivoConsulta_cita", nullable = false)
	private String motivoConsulta;

	@Column(name = "observacion_cita", nullable = false)
	private String observacion;
}
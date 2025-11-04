package com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.tratamiento;

import java.time.LocalDate;
import java.util.UUID;

import com.saludsystem.submodules.core.catalogo.adapter.entity.EspecialidadEntity;
import com.saludsystem.submodules.core.catalogo.adapter.entity.MedidaEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;
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

@Entity
@Table(name = "pacientes_plan_tratamientos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class PlanTratamientoEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id_plan_tratamiento")
	private UUID pacientePlanTratamientoId;

	@ManyToOne
	@JoinColumn(name = "id_paciente")
	private PacienteEntity pacienteEntity;

	@ManyToOne
	@JoinColumn(name = "id_doctor", nullable = false)
	private DoctorEntity doctorEntity;

	@ManyToOne
	@JoinColumn(name = "id_especialidad", nullable = false)
	private EspecialidadEntity especialidadEntity;

	@ManyToOne
	@JoinColumn(name = "id_medida", nullable = false)
	private MedidaEntity medidaEntity;

	@Column(name = "tratamienti_fecha_Inicio", nullable = false)
	private LocalDate fechaInicio;

	@Column(name = "tratamienti_fecha_fin", nullable = false)
	private LocalDate fechaFin;
}
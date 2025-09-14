package com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.tratamiento;

import java.time.LocalDate;
import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;
import com.saludsystem.submodules.core.medico.adapter.entity.DoctorEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.PacienteEntity;
import com.saludsystem.submodules.paciente.model.dtos.TipoProcedimiento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "pacientes_procedimientos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ProcedimientoEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id_procedimiento_tratamiento")
	private UUID procedimientoId;

	@ManyToOne
	@JoinColumn(name = "id_paciente")
	private PacienteEntity pacienteEntity;

	@ManyToOne
	@JoinColumn(name = "id_doctor", nullable = false)
	private DoctorEntity doctorEntity;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_prodedimiento", nullable = false)
	private TipoProcedimiento tipoProcedimiento;

	@Column(name = "descripcion_procedimiento", nullable = false)
	private String descripcion;

	@Column(name = "fecha_procedimiento", nullable = false)
	private LocalDate fecha;

	@Column(name = "resultado_procedimiento", nullable = false)
	private String resultado;
}
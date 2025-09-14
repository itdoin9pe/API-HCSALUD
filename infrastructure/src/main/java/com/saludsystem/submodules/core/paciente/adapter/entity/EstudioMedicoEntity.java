package com.saludsystem.submodules.core.paciente.adapter.entity;

import java.time.LocalDateTime;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;
import com.saludsystem.submodules.core.medico.adapter.entity.DoctorEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pacientes_estudios_medicos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class EstudioMedicoEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_paciente_estudio", nullable = false)
	private Long id;

	@Column(name = "tipo_estudio", nullable = false)
	private String tipo;

	@Column(name = "descripcion_estudio", nullable = false)
	private String descripcion;

	private LocalDateTime requestAt;

	private LocalDateTime performedAt;

	@Column(name = "estado_estudio", nullable = false)
	private String estado;

	@ManyToOne
	@JoinColumn(name = "id_paciente")
	private PacienteEntity pacienteEntity;

	@ManyToOne
	@JoinColumn(name = "id_doctor")
	private DoctorEntity doctorEntity;

	@OneToOne(mappedBy = "estudioMedicoEntity", cascade = CascadeType.ALL)
	@JoinColumn(name = "id_paciente_estudio_resultado")
	private EstudioResultadoEntity estudioResultadoEntity;
}
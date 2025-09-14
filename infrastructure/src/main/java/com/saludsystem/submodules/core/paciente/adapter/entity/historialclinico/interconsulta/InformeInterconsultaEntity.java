package com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.interconsulta;

import java.time.LocalDateTime;
import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;
import com.saludsystem.submodules.core.medico.adapter.entity.DoctorEntity;

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
@Table(name = "pacientes_interconsultas_informes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InformeInterconsultaEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id_informe_interconsulta", nullable = false)
	private UUID pacienteInformeInterconsultaId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_interconsulta", nullable = false)
	private InterconsultaEntity interconsultaEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_doctor", nullable = false)
	private DoctorEntity medicoResponsable;

	@Column(nullable = false)
	private LocalDateTime fecha;

	@Column(columnDefinition = "TEXT", nullable = false)
	private String resumenClinico;

	@Column(columnDefinition = "TEXT")
	private String diagnostico;

	@Column(columnDefinition = "TEXT")
	private String recomendaciones;

	private String archivoAdjuntoUrl;
}
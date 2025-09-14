package com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico;

import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;
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
@Table(name = "pacientes_enfermedades_actuales")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class AntecedentesEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID pacienteEnfermedadActualId;

	@ManyToOne
	@JoinColumn(name = "id_paciente", nullable = false)
	private PacienteEntity pacienteEntity;

	@Column(name = "motivo_consulta", nullable = false)
	private String motivo;

	@Column(name = "enfermedad_actual", nullable = false)
	private String enfermedad;

	@Column(name = "tiempo_enfermedad", nullable = false)
	private String tiempoEnfermedad;

	@Column(name = "signo_sintomas_principales", nullable = false)
	private String signo;

	@Column(name = "relato_cronologico", nullable = false)
	private String relato;

	@Column(name = "funciones_biologicas", nullable = false)
	private String funciones;

	@Column(name = "antecedentes_personales", nullable = false)
	private String antecedentesPersonales;

	@Column(name = "antecedentes_familiares", nullable = false)
	private String antecedentesFamiliares;

	@Column(name = "medicamente_existente", nullable = false)
	private String medicamento;

	@Column(name = "nombre_medicamente", nullable = false)
	private String nombreMedicamento;

	@Column(name = "motivo_uso", nullable = false)
	private String motivoMedicamento;

	@Column(name = "dosis", nullable = false)
	private String dosis;
}
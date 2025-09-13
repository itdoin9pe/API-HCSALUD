package com.saludsystem.submodules.paciente.model.dtos.get.historialclinico;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AntecedenteDTO
{
	private UUID pacEnfermedadActualId;

	protected UUID pacienteId;

	protected String motivo;

	protected String enfermedad;

	protected String tiempoEnfermedad;

	protected String signo;

	protected String relato;

	protected String funciones;

	protected String antecedentesPersonales;

	protected String antecedentesFamiliares;

	protected String medicamento;

	protected String nombreMedicamento;

	protected String motivoMedicamento;

	protected String dosis;
}
package com.saludsystem.submodules.paciente.model.dtos.command.edit.historialclinico;

import java.util.UUID;

import com.saludsystem.submodules.BaseDTO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AntecedenteEditCommand extends BaseDTO
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

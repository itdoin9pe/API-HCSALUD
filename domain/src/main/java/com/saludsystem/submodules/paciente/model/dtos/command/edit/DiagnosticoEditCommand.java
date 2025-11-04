package com.saludsystem.submodules.paciente.model.dtos.command.edit;

import java.time.LocalDate;
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
public class DiagnosticoEditCommand extends BaseDTO
{
	private UUID pacienteId;
	private UUID pacienteDiagnosticoId;
	private String enfermedadId;
	private LocalDate fecha;
	private String descripcion;
}
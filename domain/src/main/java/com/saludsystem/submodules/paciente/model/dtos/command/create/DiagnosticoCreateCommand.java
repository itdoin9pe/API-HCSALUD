package com.saludsystem.submodules.paciente.model.dtos.command.create;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosticoCreateCommand
{
	private UUID pacienteId;
	private String enfermedadId;
	private LocalDate fecha;
	private String descripcion;
}
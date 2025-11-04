package com.saludsystem.submodules.paciente.model.dtos.command.create.interconsulta;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InterconsultaCreateCommand
{
	private UUID pacienteId;
	private UUID medicoSolicitante;
	private UUID especialidadDestino;
	private String motivo;
	private LocalDateTime fechaSolicitud;
	private String estado;
	private String prioridad;
	private String observaciones;
	private LocalDateTime fechaAtencion;
}

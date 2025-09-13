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
public class InformeInterconsultaCreateCommand
{
	private UUID pacienteInterconsultaId;
	private UUID medicoResponsable;
	private LocalDateTime fecha;
	private String resumenClinico;
	private String diagnostico;
	private String recomendaciones;
	private String archivoAdjuntoUrl;
}

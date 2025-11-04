package com.saludsystem.submodules.paciente.model.dtos.command.create.evolucion;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotaCreateCommand
{
	private LocalDateTime fecha;
	private String tipo;
	private String contenido;
	private UUID pacienteEvolucionId;
}
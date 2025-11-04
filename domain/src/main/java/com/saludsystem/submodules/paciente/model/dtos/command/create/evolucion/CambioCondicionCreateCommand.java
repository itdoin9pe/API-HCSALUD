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
public class CambioCondicionCreateCommand
{
	private LocalDateTime fecha;
	private String descripcion;
	private UUID pacienteEvolucionId;
}
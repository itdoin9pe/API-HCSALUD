package com.saludsystem.submodules.paciente.model.dtos.get.evolucion;

import java.time.LocalDateTime;
import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AltaMedicaDTO
{
	@Schema(example = "Integer")
	private Long evolucionAltaMedicaId;

	private LocalDateTime fecha;

	private String resumenFinal;

	private UUID pacienteEvolucionId;
}
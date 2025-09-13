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
public class NotaDTO
{
	@Schema(description = "ID de la evolucion del paciente", example = "Integer")
	private Long pacienteEvolucionNotaId;

	private LocalDateTime fecha;

	private String tipo;

	private String contenido;

	private UUID pacienteEvolucionId;
}
package com.saludsystem.submodules.paciente.model.dtos.get.evolucion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EvolucionDTO
{
	private UUID pacienteEvolucionId;

	private UUID pacienteId;

	private LocalDateTime fechaInicio;

	private Boolean finalizada = false;

	private List<NotaDTO> notas;

	private List<CambioCondicionDTO> cambios;

	private Long pacienteAltaMedicaId;
}
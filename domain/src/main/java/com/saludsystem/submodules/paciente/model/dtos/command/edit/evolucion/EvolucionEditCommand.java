package com.saludsystem.submodules.paciente.model.dtos.command.edit.evolucion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.BaseDTO;
import com.saludsystem.submodules.paciente.model.dtos.get.evolucion.CambioCondicionDTO;
import com.saludsystem.submodules.paciente.model.dtos.get.evolucion.NotaDTO;

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
public class EvolucionEditCommand extends BaseDTO
{
	private UUID pacienteEvolucionId;
	private UUID pacienteId;
	private LocalDateTime fechaInicio;
	private Boolean finalizada = false;
	private List<NotaDTO> notas;
	private List<CambioCondicionDTO> cambios;
	private Long pacienteAltaMedicaId;
}
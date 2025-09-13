package com.saludsystem.submodules.paciente.model.dtos.command.edit.evolucion;

import java.time.LocalDateTime;
import java.util.UUID;

import com.saludsystem.submodules.BaseDTO;

import io.swagger.v3.oas.annotations.media.Schema;
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
public class CambioCondicionEditCommand extends BaseDTO
{
	@Schema(example = "Integer")
	private Long evolucionCambioCondicionId;

	private LocalDateTime fecha;
	private String descripcion;
	private UUID pacienteEvolucionId;
}
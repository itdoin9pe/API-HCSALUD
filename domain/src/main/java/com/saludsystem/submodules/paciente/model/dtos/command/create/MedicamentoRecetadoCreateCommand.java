package com.saludsystem.submodules.paciente.model.dtos.command.create;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentoRecetadoCreateCommand
{
	private UUID pacienteRecetaId;
	private UUID medicamentoId;
	private String dosis;
	private String frecuencia;

	@Schema(example = "0")
	private Integer duracionDias;

	private String indicaciones;
}
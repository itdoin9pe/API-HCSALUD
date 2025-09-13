package com.saludsystem.submodules.paciente.model.dtos.command.create.historialclinico;

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
public class PacienteAlergiaCreateCommand
{
	private UUID pacienteId;
	private UUID alergiaId;
	private String observacion;

	@Schema(example = "0")
	private Integer estado;
}
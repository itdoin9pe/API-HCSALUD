package com.saludsystem.submodules.paciente.model.dtos.get.historialclinico;

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
public class PacienteAlergiaDTO
{
	private UUID pacienteAlergiaId;

	private UUID pacienteId;

	private UUID alergiaId;

	private String observacion;

	@Schema(example = "0")
	private Integer estado;
}
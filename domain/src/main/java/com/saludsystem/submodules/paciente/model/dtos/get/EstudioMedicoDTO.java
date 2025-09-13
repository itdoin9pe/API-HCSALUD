package com.saludsystem.submodules.paciente.model.dtos.get;

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
public class EstudioMedicoDTO
{
	@Schema(example = "Integer")
	private Long pacienteEstudioMedicoId;

	private String tipo;

	private String descripcion;

	private String estado;

	private UUID pacienteId;

	private UUID doctorId;

	@Schema(example = "Integer")
	private Long pacienteEstudioResultadoId;
}
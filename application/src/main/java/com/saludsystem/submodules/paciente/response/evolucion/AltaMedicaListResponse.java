package com.saludsystem.submodules.paciente.response.evolucion;

import java.util.List;

import com.saludsystem.submodules.paciente.model.dtos.get.evolucion.AltaMedicaDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AltaMedicaListResponse
{
	@Schema(description = "Lista de registros de altas medicas para el paciente")
	private List<AltaMedicaDTO> data;

	@Schema(description = "Total de registros de altas medicas para el paciente", example = "0")
	private long totalData;
}
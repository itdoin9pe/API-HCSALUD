package com.saludsystem.submodules.paciente.response.evolucion;

import java.util.List;

import com.saludsystem.submodules.paciente.model.dtos.get.evolucion.EvolucionDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EvolucionListResponse
{
	@Schema(description = "Lista de evoluciones del paciente")
	private List<EvolucionDTO> data;

	@Schema(description = "Total de registrod de las evoluciones del paciente", example = "0")
	private long totalData;
}
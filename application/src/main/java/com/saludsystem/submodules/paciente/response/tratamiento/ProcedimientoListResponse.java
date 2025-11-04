package com.saludsystem.submodules.paciente.response.tratamiento;

import java.util.List;

import com.saludsystem.submodules.paciente.model.dtos.get.tratamiento.ProcedimientoDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProcedimientoListResponse
{
	@Schema(description = "Lita de procedimientos para tratamiento del paciente")
	private List<ProcedimientoDTO> data;

	@Schema(description = "Total de procedimientos para tratamiento del paciente", example = "0")
	private long totalData;
}
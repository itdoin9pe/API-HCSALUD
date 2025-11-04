package com.saludsystem.submodules.paciente.response;

import java.util.List;

import com.saludsystem.submodules.paciente.model.dtos.get.EstudioResultadoDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstudioResultadoListResponse
{
	@Schema(description = "Lista de registros sobre resultado medicos de los estudios del paciente")
	private List<EstudioResultadoDTO> data;

	@Schema(description = "Total de todos registros sobre resultado medicos de los estudios del paciente", example = "0")
	private long totalData;
}
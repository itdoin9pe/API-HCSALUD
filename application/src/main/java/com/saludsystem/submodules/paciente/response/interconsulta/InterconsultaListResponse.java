package com.saludsystem.submodules.paciente.response.interconsulta;

import java.util.List;

import com.saludsystem.submodules.paciente.model.dtos.get.interconsulta.InterconsultaDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InterconsultaListResponse
{
	@Schema(description = "Lista de registros de interconsulta para pacientes")
	public List<InterconsultaDTO> data;

	@Schema(description = "Total de registros de la listas de interconsultas para pacientes", example = "0")
	public long totalData;
}
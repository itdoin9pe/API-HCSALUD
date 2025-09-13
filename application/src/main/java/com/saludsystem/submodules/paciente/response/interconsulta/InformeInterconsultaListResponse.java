package com.saludsystem.submodules.paciente.response.interconsulta;

import java.util.List;

import com.saludsystem.submodules.paciente.model.dtos.get.interconsulta.InformeInterconsultaDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InformeInterconsultaListResponse
{
	@Schema(description = "Lista de registros de informes de interconsulta para pacientes")
	private List<InformeInterconsultaDTO> data;

	@Schema(description = "Total de registros de la listas de informes de interconsultas para pacientes", example = "0")
	private long totalData;
}
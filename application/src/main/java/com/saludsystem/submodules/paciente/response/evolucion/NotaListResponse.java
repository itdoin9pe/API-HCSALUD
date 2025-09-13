package com.saludsystem.submodules.paciente.response.evolucion;

import java.util.List;

import com.saludsystem.submodules.paciente.model.dtos.get.evolucion.NotaDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotaListResponse
{
	@Schema(description = "Lista de registros para notas de evolucion del paciente")
	private List<NotaDTO> data;

	@Schema(description = "Total de registros para notas de evolucion del paciente", example = "0")
	private long totalData;
}
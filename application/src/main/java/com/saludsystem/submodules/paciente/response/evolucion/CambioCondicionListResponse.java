package com.saludsystem.submodules.paciente.response.evolucion;

import java.util.List;

import com.saludsystem.submodules.paciente.model.dtos.get.evolucion.CambioCondicionDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CambioCondicionListResponse
{
	@Schema(description = "Lista de registros para el cambio de condicion em la evolucion del paciente")
	private List<CambioCondicionDTO> data;

	@Schema(description = "Total de registros para el cambio de condicion em la evolucion del paciente", example = "0")
	private long totalData;
}
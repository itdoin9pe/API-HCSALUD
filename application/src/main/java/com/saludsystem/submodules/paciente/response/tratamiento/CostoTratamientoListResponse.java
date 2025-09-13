package com.saludsystem.submodules.paciente.response.tratamiento;

import java.util.List;

import com.saludsystem.submodules.paciente.model.dtos.get.tratamiento.CostoTratamientoDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CostoTratamientoListResponse
{
	@Schema(description = "Lista de los costos para tratamiento del paciente")
	private List<CostoTratamientoDTO> data;

	@Schema(description = "Total de los costos para tratamiento del paciente", example = "0")
	private long totalData;
}
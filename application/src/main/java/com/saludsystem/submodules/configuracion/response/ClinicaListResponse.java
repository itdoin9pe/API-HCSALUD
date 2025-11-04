package com.saludsystem.submodules.configuracion.response;

import java.util.List;

import com.saludsystem.submodules.configuracion.model.dtos.ClinicaDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClinicaListResponse
{
	@Schema(description = "Lista de Sedes")
	private List<ClinicaDTO> data;

	@Schema(description = "Número total de Sedes", example = "0")
	private long totalData;
}
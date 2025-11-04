package com.saludsystem.submodules.configuracion.response;

import java.util.List;

import com.saludsystem.submodules.configuracion.model.dtos.SedeDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SedeListResponse
{
	@Schema(description = "Lista de Sedes")
	private List<SedeDTO> data;

	@Schema(description = "Número total de Sedes", example = "0")
	private long totalData;
}
package com.saludsystem.submodules.operaciones.response;

import java.util.List;

import com.saludsystem.submodules.operaciones.model.dtos.UnidadDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnidadListResponse
{
	@Schema(description = "Lista de unidades")
	private List<UnidadDTO> data;

	@Schema(description = "Numero total de unidades", example = "0")
	private long totalData;
}
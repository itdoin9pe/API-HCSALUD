package com.saludsystem.submodules.mantenimiento.response;

import java.util.List;

import com.saludsystem.submodules.mantenimiento.model.dtos.MonedaDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MonedaListResponse
{
	@Schema(description = "Lista de Tipo de Monedas")
	private List<MonedaDTO> data;

	@Schema(description = "Número total de Tipos de Monedas", example = "0")
	private long totalData;
}
package com.saludsystem.submodules.mantenimiento.response;

import java.util.List;

import com.saludsystem.submodules.mantenimiento.model.dtos.TipoTarjetaDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoTarjetaListResponse
{
	@Schema(description = "Lista de Tipo de tarjetas")
	private List<TipoTarjetaDTO> data;

	@Schema(description = "Número total de tipos de tarjetas", example = "0")
	private long totalData;
}
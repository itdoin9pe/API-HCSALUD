package com.saludsystem.submodules.mantenimiento.response;

import java.util.List;

import com.saludsystem.submodules.mantenimiento.model.dtos.CajaDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CajaListResponse
{
	@Schema(description = "Lista de Cajas")
	private List<CajaDTO> data;

	@Schema(description = "Número total de Cajas Registradas", example = "0")
	private long totalData;
}
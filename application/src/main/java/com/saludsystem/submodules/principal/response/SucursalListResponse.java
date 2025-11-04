package com.saludsystem.submodules.principal.response;

import java.util.List;

import com.saludsystem.submodules.principal.model.dtos.SucursalDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SucursalListResponse
{
	@Schema(description = "Lista de Sucursales")
	private List<SucursalDTO> data;

	@Schema(description = "Numero total de Sucursales", example = "0")
	private long totalData;
}
package com.saludsystem.submodules.configuracion.response;

import java.util.List;

import com.saludsystem.submodules.configuracion.model.dtos.PermisoDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermisoListResponse
{
	@Schema(description = "Lista de Permisos")
	private List<PermisoDTO> data;

	@Schema(description = "Número total de Permisos", example = "0")
	private long totalData;
}
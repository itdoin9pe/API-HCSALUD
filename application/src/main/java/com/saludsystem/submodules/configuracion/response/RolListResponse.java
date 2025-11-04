package com.saludsystem.submodules.configuracion.response;

import java.util.List;

import com.saludsystem.submodules.configuracion.model.dtos.RolDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RolListResponse
{
	@Schema(description = "Lista de Roles")
	private List<RolDTO> data;

	@Schema(description = "Número total de Roles", example = "0")
	private long totalData;
}
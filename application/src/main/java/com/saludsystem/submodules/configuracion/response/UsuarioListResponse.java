package com.saludsystem.submodules.configuracion.response;

import java.util.List;

import com.saludsystem.submodules.configuracion.model.dtos.UsuarioDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UsuarioListResponse
{
	@Schema(description = "Lista de Usuarios")
	private List<UsuarioDTO> data;

	@Schema(description = "Número total de Usuarios", example = "0")
	private long totalData;
}
package com.saludsystem.submodules.mantenimiento.response;

import java.util.List;

import com.saludsystem.submodules.mantenimiento.model.dtos.CuentaDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CuentaListResponse
{
	@Schema(description = "Lista de Alergias")
	private List<CuentaDTO> data;

	@Schema(description = "Número total de Alergias Registradas", example = "0")
	private long totalData;
}
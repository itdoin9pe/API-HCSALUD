package com.saludsystem.submodules.operaciones.response;

import java.util.List;

import com.saludsystem.submodules.operaciones.model.dtos.PresentacionDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PresentacionListResponse
{
	@Schema(description = "Lista de presentaciones")
	private List<PresentacionDTO> data;

	@Schema(description = "Total de registros de Presentacion", example = "0")
	private long totalData;
}
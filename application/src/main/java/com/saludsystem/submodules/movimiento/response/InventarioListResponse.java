package com.saludsystem.submodules.movimiento.response;

import java.util.List;

import com.saludsystem.submodules.movimiento.model.dtos.command.InventarioCreateCommand;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventarioListResponse
{
	@Schema(description = "Lista de registros para Inventario")
	private List<InventarioCreateCommand> data;

	@Schema(description = "Total de registros para Inventario", example = "0")
	private long totalData;
}
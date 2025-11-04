package com.saludsystem.submodules.movimiento.response;

import java.util.List;

import com.saludsystem.submodules.movimiento.model.dtos.command.CompraDetalleCreateCommand;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompraDetalleListResponse
{
	@Schema(description = "Lista de registros - detalles de la compra")
	private List<CompraDetalleCreateCommand> data;

	@Schema(description = "Total de registro - detalles de la compra", example = "0")
	private long totalData;
}
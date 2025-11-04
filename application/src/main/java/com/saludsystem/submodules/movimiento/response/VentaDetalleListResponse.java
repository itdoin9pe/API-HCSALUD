package com.saludsystem.submodules.movimiento.response;

import java.util.List;

import com.saludsystem.submodules.movimiento.model.dtos.command.VentaDetalleCreateCommand;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VentaDetalleListResponse
{
	@Schema(description = "Lista de registro para detalles de venta")
	private List<VentaDetalleCreateCommand> data;

	@Schema(description = "Total de registros para detalles de la venta", example = "0")
	private long totalData;
}
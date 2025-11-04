package com.saludsystem.submodules.movimiento.response;

import java.util.List;

import com.saludsystem.submodules.movimiento.model.dtos.command.CompraCreateCommand;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompraListResponse
{
	@Schema(description = "Lista de registos de compras")
	private List<CompraCreateCommand> data;

	@Schema(description = "Total de registro de compras", example = "0")
	private long totalData;
}
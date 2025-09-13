package com.saludsystem.submodules.movimiento.response;

import java.util.List;

import com.saludsystem.submodules.movimiento.model.dtos.command.AlmacenCreateCommand;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlmacenListResponse
{
	@Schema(description = "Lista de alamacenes")
	private List<AlmacenCreateCommand> data;

	@Schema(description = "Total de almacences", example = "0")
	private long totalData;
}
package com.saludsystem.submodules.mantenimiento.response;

import java.util.List;

import com.saludsystem.submodules.mantenimiento.model.dtos.BancoDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BancoListResponse
{
	@Schema(description = "Lista de Bancos")
	private List<BancoDTO> data;

	@Schema(description = "Número total de bancos", example = "0")
	private long totalData;
}
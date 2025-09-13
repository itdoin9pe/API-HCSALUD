package com.saludsystem.submodules.principal.response;

import java.util.List;

import com.saludsystem.submodules.principal.model.dtos.EstudioDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstudioListResponse
{
	@Schema(description = "Lista de Estudios")
	private List<EstudioDTO> data;

	@Schema(description = "Numero total de estudios formativos", example = "0")
	private long totalData;
}
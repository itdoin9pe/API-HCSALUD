package com.saludsystem.submodules.catalogo.response;

import java.util.List;

import com.saludsystem.submodules.catalogo.model.dto.TipoConceptoDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoConceptoListResponse
{
	@Schema(description = "Lista de Tipos de conceptos")
	private List<TipoConceptoDTO> data;

	@Schema(description = "Número total de tipos de conceptos", example = "0")
	private long totalData;
}
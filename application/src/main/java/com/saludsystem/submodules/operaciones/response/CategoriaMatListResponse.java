package com.saludsystem.submodules.operaciones.response;

import java.util.List;

import com.saludsystem.submodules.operaciones.model.dtos.CategoriaMatDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaMatListResponse
{
	@Schema(description = "Lista de Categorias Materiales")
	private List<CategoriaMatDTO> data;

	@Schema(description = "Total de categoria nateriales", example = "0")
	private long totalData;
}
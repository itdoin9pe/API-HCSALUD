package com.saludsystem.submodules.catalogo.response;

import java.util.List;

import com.saludsystem.submodules.catalogo.model.dto.CategoriaDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaListResponse
{
	@Schema(description = "Lista de Categorias - Catalogo")
	private List<CategoriaDTO> data;

	@Schema(description = "Número total de Categorias Registradas", example = "0")
	private long totalData;
}
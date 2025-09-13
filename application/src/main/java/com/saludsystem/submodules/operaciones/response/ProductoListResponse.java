package com.saludsystem.submodules.operaciones.response;

import java.util.List;

import com.saludsystem.submodules.operaciones.model.dtos.ProductoDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoListResponse
{
	@Schema(description = "Lista de productos registrados")
	private List<ProductoDTO> data;

	@Schema(description = "Total de productos registrados", example = "0")
	private long totalData;
}
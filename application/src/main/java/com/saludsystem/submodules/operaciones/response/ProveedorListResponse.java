package com.saludsystem.submodules.operaciones.response;

import java.util.List;

import com.saludsystem.submodules.operaciones.model.dtos.ProveedorDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProveedorListResponse
{
	@Schema(description = "Lista de proveedores")
	private List<ProveedorDTO> data;

	@Schema(description = "Total de proveedores", example = "0")
	private long totalData;
}
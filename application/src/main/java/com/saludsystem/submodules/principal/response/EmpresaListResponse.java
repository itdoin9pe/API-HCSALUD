package com.saludsystem.submodules.principal.response;

import java.util.List;

import com.saludsystem.submodules.principal.model.dtos.EmpresaDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaListResponse
{
	@Schema(description = "Lista de Empresas")
	private List<EmpresaDTO> data;

	@Schema(description = "Número total de Empresas", example = "0")
	private long totalData;
}
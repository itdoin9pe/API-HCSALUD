package com.saludsystem.submodules.catalogo.response;

import java.util.List;

import com.saludsystem.submodules.catalogo.model.dto.ConsentimientoDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsentimientoListResponse
{
	@Schema(description = "Lista de Consentimientos")
	private List<ConsentimientoDTO> data;

	@Schema(description = "Número total de Consentimientos Registradas", example = "0")
	private long totalData;
}
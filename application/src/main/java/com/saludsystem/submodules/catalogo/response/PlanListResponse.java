package com.saludsystem.submodules.catalogo.response;

import java.util.List;

import com.saludsystem.submodules.catalogo.model.dto.PlanDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanListResponse
{
	@Schema(description = "Lista de Planes")
	private List<PlanDTO> data;

	@Schema(description = "Número total de Planes", example = "0")
	private long totalData;
}
package com.saludsystem.submodules.principal.response;

import java.util.List;

import com.saludsystem.submodules.principal.model.dtos.InformacionClinicaDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InformacionClinicaListResponse
{
	@Schema(description = "Lista de Informaciones Clinicas")
	private List<InformacionClinicaDTO> data;

	@Schema(description = "Número total de Informaciones Clinicas", example = "0")
	private long totalData;
}
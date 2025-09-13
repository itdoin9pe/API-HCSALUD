package com.saludsystem.submodules.paciente.response;

import java.util.List;

import com.saludsystem.submodules.paciente.model.dtos.get.PConsentimientoDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PConsentimientoListResponse
{
	@Schema(description = "Lista de consentimientos del paciente")
	private List<PConsentimientoDTO> data;

	@Schema(description = "Total de registos para el consentimiento del paciente", example = "0")
	private long totalData;
}
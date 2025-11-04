package com.saludsystem.submodules.paciente.response;

import java.util.List;

import com.saludsystem.submodules.paciente.model.dtos.get.EstudioMedicoDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstudioMedicoListResponse
{
	@Schema(description = "Lista de registros para estudios medicos del paciente")
	private List<EstudioMedicoDTO> data;

	@Schema(description = "Total de registros para estudios medicos del paciente", example = "0")
	private long totalData;
}
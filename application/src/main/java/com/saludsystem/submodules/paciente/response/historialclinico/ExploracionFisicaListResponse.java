package com.saludsystem.submodules.paciente.response.historialclinico;

import java.util.List;

import com.saludsystem.submodules.paciente.model.dtos.get.historialclinico.ExploracionFisicaDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExploracionFisicaListResponse
{
	@Schema(description = "Lista de registros de exploraciones fisicas del paciente")
	private List<ExploracionFisicaDTO> data;

	@Schema(description = "Total de registros de exploraciones fisicas del paciente", example = "0")
	private long totalData;
}
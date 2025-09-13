package com.saludsystem.submodules.paciente.response;

import java.util.List;

import com.saludsystem.submodules.paciente.model.dtos.get.MedicamentoRecetadoDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicamentoRecetadoListResponse
{
	@Schema(description = "Lista de medicamentos recetados registrados")
	private List<MedicamentoRecetadoDTO> data;

	@Schema(description = "Total de medicamentos recetados registrados", example = "0")
	private long totalData;
}
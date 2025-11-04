package com.saludsystem.submodules.catalogo.response;

import java.util.List;

import com.saludsystem.submodules.catalogo.model.dto.MedicamentoDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicamentoListResponse
{
	@Schema(description = "Lista de registros para medicamentos")
	private List<MedicamentoDTO> data;

	@Schema(description = "Total de registros para medicamentos", example = "0")
	private long totalData;
}
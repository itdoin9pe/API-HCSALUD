package com.saludsystem.submodules.catalogo.response;

import java.util.List;

import com.saludsystem.submodules.catalogo.model.dto.MedidaDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedidaListResponse
{
	@Schema(description = "Lista de Medidas")
	private List<MedidaDTO> data;

	@Schema(description = "Numero total de medidas registradas", example = "0")
	private long totalData;
}
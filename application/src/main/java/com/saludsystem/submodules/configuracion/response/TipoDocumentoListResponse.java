package com.saludsystem.submodules.configuracion.response;

import java.util.List;

import com.saludsystem.submodules.configuracion.model.dtos.TipoDocumentoDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class TipoDocumentoListResponse
{
	@Schema(description = "Lista de Sedes")
	private List<TipoDocumentoDTO> data;

	@Schema(description = "Número total de Tipos de Documentos", example = "0")
	private long totalData;
}
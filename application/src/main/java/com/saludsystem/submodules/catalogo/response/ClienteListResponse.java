package com.saludsystem.submodules.catalogo.response;

import java.util.List;

import com.saludsystem.submodules.catalogo.model.dto.ClienteDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteListResponse
{
	@Schema(description = "Lista de Clientes")
	private List<ClienteDTO> data;

	@Schema(description = "Número total de Clientes Registradas", example = "0")
	private long totalData;
}
package com.saludsystem.submodules.mantenimiento.response;

import java.util.List;

import com.saludsystem.submodules.mantenimiento.model.dtos.TipoPagoDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoPagoListResponse
{
	@Schema(description = "Lista de tipos de pago")
	private List<TipoPagoDTO> data;

	@Schema(description = "Número total de tipos de pago", example = "0")
	private long totalData;
}
package com.saludsystem.submodules.paciente.response.estadocuenta;

import java.util.List;

import com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta.EstadoCuentaDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoCuentaListResponse
{
	@Schema(description = "Lista de registros del estado de cuenta del paciente")
	private List<EstadoCuentaDTO> data;

	@Schema(description = "Total de registros de estados de cuentas del paciente", example = "0")
	private long totalData;
}
package com.saludsystem.infrastructure.adapters.in.response.mantenimiento;

import com.saludsystem.application.dtos.mantenimiento.get.TipoGastoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TIpoGastoResponse {

    @Schema(description = "Lista de Tipos de gasto")
    private List<TipoGastoDTO> data;

    @Schema(description = "Número total de tipos de gastos registradas", example = "0")
    private long totalData;

}
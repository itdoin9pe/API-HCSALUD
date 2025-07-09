package com.saludsystem.mantenimiento.infrastructure.adapters.in.response;

import com.saludsystem.mantenimiento.application.dto.get.TipoGastoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TIpoGastoListResponse {

    @Schema(description = "Lista de Tipos de gasto")
    private List<TipoGastoDTO> data;

    @Schema(description = "Número total de tipos de gastos registradas", example = "0")
    private long totalData;

}
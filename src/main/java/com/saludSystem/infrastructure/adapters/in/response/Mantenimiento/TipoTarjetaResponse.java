package com.saludSystem.infrastructure.adapters.in.response.Mantenimiento;

import com.saludSystem.application.dtos.Mantenimiento.GET.TipoTarjetaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TipoTarjetaResponse {

    @Schema(description = "Lista de Tipo de tarjetas")
    private List<TipoTarjetaDTO> data;

    @Schema(description = "Número total de tipos de tarjetas", example = "0")
    private long totalData;

}
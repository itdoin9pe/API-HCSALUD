package com.saludsystem.application.mantenimiento.response;

import com.saludsystem.application.mantenimiento.dtos.get.TipoTarjetaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TipoTarjetaListResponse {

    @Schema(description = "Lista de Tipo de tarjetas")
    private List<TipoTarjetaDTO> data;

    @Schema(description = "Número total de tipos de tarjetas", example = "0")
    private long totalData;

}
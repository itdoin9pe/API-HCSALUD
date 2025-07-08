package com.saludsystem.mantenimiento.infrastructure.adapters.in.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CajaListResponse {

    @Schema(description = "Lista de Cajas")
    private List<com.saludsystem.mantenimiento.application.dto.res.CajaResponse> data;

    @Schema(description = "Número total de Cajas Registradas", example = "0")
    private long totalData;

}
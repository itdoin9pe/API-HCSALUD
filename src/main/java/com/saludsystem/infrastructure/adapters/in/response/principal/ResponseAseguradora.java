package com.saludsystem.infrastructure.adapters.in.response.principal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseAseguradora {

    @Schema(description = "Lista de aseguradoras")
    private List<com.saludsystem.application.dtos.principal.res.AseguradoraResponse> data;

    @Schema(description = "Número total de aseguradoras", example = "0")
    private long totalData;

}

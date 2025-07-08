package com.saludsystem.principal.infrastructure.adapters.in.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PaisListResponse {

    @Schema(description = "Lista de Paises")
    private List<com.saludsystem.principal.application.dto.res.PaisResponse> data;

    @Schema(description = "Numero total de Paises", example = "0")
    private long totalData;

}
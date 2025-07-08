package com.saludsystem.operaciones.infrastructure.adapters.in.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MarcaListResponse {

    @Schema(description = "Lista de marcas registradas")
    private List<com.saludsystem.operaciones.application.dto.res.MarcaResponse> data;

    @Schema(description = "Total de marcas registradas", example = "0")
    private long totalData;

}
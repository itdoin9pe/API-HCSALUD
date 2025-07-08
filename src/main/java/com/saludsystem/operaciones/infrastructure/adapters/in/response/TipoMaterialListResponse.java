package com.saludsystem.operaciones.infrastructure.adapters.in.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class TipoMaterialListResponse {

    @Schema(description = "Lista de tipo materiales")
    private List<com.saludsystem.operaciones.application.dto.res.TipoMaterialResponse> data;

    @Schema(description = "Total de registros de Tipos de materiales", example = "0")
    private long totalData;

}
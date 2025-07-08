package com.saludsystem.configuracion.infrastructure.adapters.in.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class TipoDocumentoListResponse {

    @Schema(description = "Lista de Sedes")
    private List<com.saludsystem.configuracion.application.dto.res.TipoDocumentoResponse> data;

    @Schema(description = "Número total de Tipos de Documentos", example = "0")
    private long totalData;

}
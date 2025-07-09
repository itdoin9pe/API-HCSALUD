package com.saludsystem.configuracion.infrastructure.adapters.in.response;

import com.saludsystem.configuracion.application.dto.get.TipoDocumentoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class TipoDocumentoListResponse {

    @Schema(description = "Lista de Sedes")
    private List<TipoDocumentoDTO> data;

    @Schema(description = "Número total de Tipos de Documentos", example = "0")
    private long totalData;

}
package com.saludSystem.dtos.responses.Configuration;

import com.saludSystem.dtos.configuration.TipoDocumento.TipoDocumentoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class TipoDocumentoResponse {

    @Schema(description = "Lista de Sedes")
    private List<TipoDocumentoDTO> data;

    @Schema(description = "Número total de Tipos de Documentos", example = "0")
    private long totalData;

}
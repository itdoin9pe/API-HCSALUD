package com.saludSystem.infrastructure.adapters.in.response.Configuracion;

import com.saludSystem.application.dtos.Configuracion.GET.TipoDocumentoDTO;
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
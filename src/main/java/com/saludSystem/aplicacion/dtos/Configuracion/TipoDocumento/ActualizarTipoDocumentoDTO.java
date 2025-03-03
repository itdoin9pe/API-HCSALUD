package com.saludSystem.aplicacion.dtos.Configuracion.TipoDocumento;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class ActualizarTipoDocumentoDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID tDocumentoId;

    private String tipoComprobante;

    private String serie;

    @Schema(description = "Valor Inicio", example = "0")
    private Integer inicio;

    @Schema(description = "Valor Fin", example = "0")
    private Integer fin;

    @Schema(description = "Valor Correlativo", example = "0")
    private Integer correlativoActual;

    @Schema(description = "Estado del tipo de Documento", example = "0" )
    private Integer estado;

}
package com.saludsystem.submodules.configuracion.dtos.post;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CrearTipoDocumentoDTO {
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
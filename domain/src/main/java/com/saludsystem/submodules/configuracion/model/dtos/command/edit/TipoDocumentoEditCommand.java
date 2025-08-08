package com.saludsystem.submodules.configuracion.model.dtos.command.edit;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TipoDocumentoEditCommand extends BaseDTO {
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
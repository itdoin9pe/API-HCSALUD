package com.saludsystem.catalogo.application.dtos.put;

import com.saludsystem.shared.application.dto.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarTipoConceptoDTO extends BaseDTO {
    private UUID tipoConceptoId;
    private String nombre;
    @Schema(description = "Estado del Tipo Concepto (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;
}
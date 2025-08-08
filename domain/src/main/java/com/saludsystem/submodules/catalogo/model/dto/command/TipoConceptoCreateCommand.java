package com.saludsystem.submodules.catalogo.model.dto.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TipoConceptoCreateCommand {
    private String nombre;
    @Schema(description = "Estado del Tipo Concepto (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;
}
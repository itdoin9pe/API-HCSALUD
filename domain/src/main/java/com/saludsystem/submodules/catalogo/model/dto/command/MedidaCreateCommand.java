package com.saludsystem.submodules.catalogo.model.dto.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedidaCreateCommand {
    private String nombre;
    @Schema(description = "Estado de la medida (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;
}
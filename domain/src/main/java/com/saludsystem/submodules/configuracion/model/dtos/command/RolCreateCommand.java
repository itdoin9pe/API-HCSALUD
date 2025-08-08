package com.saludsystem.submodules.configuracion.model.dtos.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RolCreateCommand {

    private String nombre;
    @Schema(description = "Estado del rol (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}
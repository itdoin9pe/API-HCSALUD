package com.saludsystem.submodules.principal.model.dtos.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstudioCreateCommand {

    @Schema(description = "Descripción de estudios", example = "string")
    private String descripcion;

}
package com.saludsystem.submodules.catalogo.model.dto.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ConsentimientoCreateCommand {
    private String nombre;

    private String observacion;

    private String texto;

    @Schema(description = "estado del consentimiento", example = "0")
    private Integer estado;
}
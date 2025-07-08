package com.saludsystem.principal.application.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.UUID;

@Data
public class EstudioResponse {

    private UUID estudioId;

    @Schema(description = "Descripción de estudio educativo", example = "string")
    private String descripcion;

}
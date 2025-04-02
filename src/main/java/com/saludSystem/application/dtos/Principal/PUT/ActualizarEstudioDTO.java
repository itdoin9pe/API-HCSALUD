package com.saludSystem.application.dtos.Principal.PUT;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.UUID;

@Data
public class ActualizarEstudioDTO {

    private UUID hospitalId;

    @Schema(description = "ID de estudios educativos", example = "Integer")
    private UUID estudioId;

    @Schema(description = "Descripción de estudio educativo", example = "string")
    private String descripcion;

}
package com.saludSystem.application.dtos.Operaciones.PUT;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.UUID;

@Data
public class ActualizarPresentacionDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID presentacionId;

    private String nombre;

    @Schema(description = "Estado de presentacion", example = "0")
    private Integer estado;

}
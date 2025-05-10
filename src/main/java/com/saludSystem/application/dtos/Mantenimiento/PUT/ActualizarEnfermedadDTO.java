package com.saludSystem.application.dtos.Mantenimiento.PUT;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.UUID;

@Data
public class ActualizarEnfermedadDTO {

    private UUID hospitalId;

    private UUID userId;

    private String enfermedadId;

    private String descripcion;

    @Schema(description = "Estado de Diagnostico (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}
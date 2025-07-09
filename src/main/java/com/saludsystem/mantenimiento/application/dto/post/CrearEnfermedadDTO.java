package com.saludsystem.mantenimiento.application.dto.post;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CrearEnfermedadDTO {
    private String descripcion;
    @Schema(description = "Estado de Diagnostico (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;
}
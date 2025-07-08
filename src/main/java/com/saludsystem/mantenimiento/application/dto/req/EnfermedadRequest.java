package com.saludsystem.mantenimiento.application.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class EnfermedadRequest {

    private String enfermedadId;

    private String descripcion;

    @Schema(description = "Estado de Diagnostico (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}
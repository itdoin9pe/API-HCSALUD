package com.saludSystem.application.dtos.Mantenimiento.GET;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EnfermedadDTO {

    private String enfermedadId;

    private String descripcion;

    @Schema(description = "Estado de Diagnostico (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}
package com.saludSystem.dtos.catalago.Especialidad;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class CrearEspecialidadDTO {
    private String nombre;
    private String descripcion;
    @Min(value = 0)
    @Max(value = 1)
    @Schema(description = "Estado de Especialidades (0 = inactivo, 1 = activo)", example = "0", defaultValue = "0")
    private Integer estado;
}

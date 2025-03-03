package com.saludSystem.application.dtos.catalago.Medida;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class CrearMedidaDTO {
    private String nombre;

    @Min(value = 0)
    @Max(value = 1)
    @Schema(description = "Estado de la medida (0 = inactivo, 1 = activo)", example = "0", defaultValue = "0")
    private Integer estado;

}
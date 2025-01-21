package com.saludSystem.dtos.Generals;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.util.UUID;

@Data
public class AseguradoraDTO {

    private UUID aseguradoraId;

    private String descripcion;

    @Min(value = 0)
    @Max(value = 1)
    @Schema(description = "Estado de la aseguradora (0 = inactivo, 1 = activo)", example = "0", defaultValue = "0")
    private Integer estado;

}
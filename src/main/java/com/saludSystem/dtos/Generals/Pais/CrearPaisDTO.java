package com.saludSystem.dtos.Generals.Pais;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearPaisDTO {
    private String iso;
    private String nombre;
    private String gentilicio;
    @Min(value = 0)
    @Max(value = 1)
    @Schema(description = "Estado de la aseguradora (0 = inactivo, 1 = activo)", example = "0", defaultValue = "0")
    private Integer orden;
}

package com.saludSystem.aplicacion.dtos.Generals.Aseguradora;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CrearAseguradoraDTO {

    private String descripcion;

    @Schema(description = "Estado de la aseguradora (0 = inactivo, 1 = activo)", example = "0", defaultValue = "0")
    private Integer estado;

}
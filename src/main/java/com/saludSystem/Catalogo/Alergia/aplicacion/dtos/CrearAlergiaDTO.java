package com.saludSystem.Catalogo.Alergia.aplicacion.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CrearAlergiaDTO {

    private String nombre;

    @Schema(description = "Estado de Alergias (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}
package com.saludSystem.application.dtos.Catalogo.POST;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CrearApoderadoDTO {

    private String nombre;

    private String nroDocumento;

    private String direccion;

    private String telefono;

    @Schema(description = "Estado de Apoderado (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}
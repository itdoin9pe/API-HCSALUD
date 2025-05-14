package com.saludSystem.application.dtos.Catalogo.GET;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class ApoderadoDTO {

    private UUID apoderadoId;

    private String nombre;

    private String nroDocumento;

    private String direccion;

    private String telefono;

    @Schema(description = "Estado de Apoderado (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}
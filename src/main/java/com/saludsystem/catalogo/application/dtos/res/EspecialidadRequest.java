package com.saludsystem.catalogo.application.dtos.res;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.UUID;

@Data
public class EspecialidadRequest {

    private UUID especialidadId;

    private String nombre;

    private String descripcion;

    @Schema(description = "Estado de Especialidades (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}
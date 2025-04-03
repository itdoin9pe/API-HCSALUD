package com.saludSystem.application.dtos.Operaciones.PUT;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.UUID;

@Data
public class ActualizarUnidadDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID unidadId;

    private String nombre;

    private String siglas;

    private String descripcion;

    @Schema(description = "Estado de la unidad", example = "0")
    private Integer estado;

}
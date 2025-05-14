package com.saludSystem.application.dtos.Operaciones.PUT;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class ActualizarCategoriaMatDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID categoriaMaterialId;

    private String nombre;

    private String descripcion;

    @Schema(description = "Estado de categorias materiales", example = "0")
    private Integer estado;

}
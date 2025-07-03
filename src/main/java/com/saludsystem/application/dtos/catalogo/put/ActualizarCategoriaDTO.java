package com.saludsystem.application.dtos.catalogo.put;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class ActualizarCategoriaDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID categoriaId;

    private String nombre;

    @Schema(description = "Estado de la Categoria (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}
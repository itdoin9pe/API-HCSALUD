package com.saludsystem.operaciones.application.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.UUID;

@Data
public class CategoriaMatResponse {

    private UUID categoriaMaterialId;

    private String nombre;

    private String descripcion;

    @Schema(description = "Estado de categorias materiales", example = "0")
    private Integer estado;

}
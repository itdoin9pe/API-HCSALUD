package com.saludsystem.operaciones.application.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CategotiaMatRequest {

    private String nombre;

    private String descripcion;

    @Schema(description = "Estado de categorias materiales", example = "0")
    private Integer estado;

}
package com.saludsystem.catalogo.application.dtos.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MedidaRequest {

    private String nombre;

    @Schema(description = "Estado de la medida (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}
package com.saludsystem.operaciones.application.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MarcaRequest {

    private String nombre;

    @Schema(description = "Estado de marca", example = "0")
    private Integer estado;

}
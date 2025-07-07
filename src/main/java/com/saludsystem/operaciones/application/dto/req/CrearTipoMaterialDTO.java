package com.saludsystem.operaciones.application.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CrearTipoMaterialDTO {

    private String nombre;

    private String descripcion;

    @Schema(description = "Estado del tipo de material", example = "0")
    private Integer estado;

}
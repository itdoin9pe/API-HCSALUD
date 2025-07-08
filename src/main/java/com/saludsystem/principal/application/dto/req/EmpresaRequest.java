package com.saludsystem.principal.application.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class EmpresaRequest {

    private String descripcion;

    @Schema(description = "Estado de la empresa (0 = inactivo, 1 = activo)", example = "0", defaultValue = "0")
    private Integer estado;

}
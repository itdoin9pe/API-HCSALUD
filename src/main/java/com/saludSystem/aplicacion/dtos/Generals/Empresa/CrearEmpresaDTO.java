package com.saludSystem.aplicacion.dtos.Generals.Empresa;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearEmpresaDTO {

    private String descripcion;

    @Schema(description = "Estado de la empresa (0 = inactivo, 1 = activo)", example = "0", defaultValue = "0")
    private Integer estado;

}
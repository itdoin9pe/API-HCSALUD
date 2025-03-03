package com.saludSystem.application.dtos.Generals.Empresa;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class EmpresaDTO {

    private UUID empresaId;

    private String descripcion;

    @Schema(description = "Estado de la aseguradora (0 = inactivo, 1 = activo)", example = "0", defaultValue = "0")
    private Integer estado;

}
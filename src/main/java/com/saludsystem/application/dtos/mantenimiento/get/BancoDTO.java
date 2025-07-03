package com.saludsystem.application.dtos.mantenimiento.get;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class BancoDTO {

    private UUID bancoId;

    private String descripcion;

    @Schema(description = "Estado de Banco (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}
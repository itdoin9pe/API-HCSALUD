package com.saludsystem.application.dtos.catalogo.res;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.UUID;

@Data
public class ActualizarMedidaDTO {

    private UUID hospitalId;

    private UUID medidaId;

    private String nombre;

    @Schema(description = "Estado de la medida (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}
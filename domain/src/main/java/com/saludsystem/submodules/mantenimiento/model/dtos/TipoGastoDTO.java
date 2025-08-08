package com.saludsystem.submodules.mantenimiento.model.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TipoGastoDTO {

    private UUID conceptoGastoId;

    private String nombre;

    @Schema(description = "Estado de Tipos de gastos (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}
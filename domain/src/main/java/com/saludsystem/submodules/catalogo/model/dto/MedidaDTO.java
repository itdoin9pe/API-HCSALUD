package com.saludsystem.submodules.catalogo.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MedidaDTO {

    private UUID medidaId;

    private String nombre;

    @Schema(description = "Estado de la medida (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}
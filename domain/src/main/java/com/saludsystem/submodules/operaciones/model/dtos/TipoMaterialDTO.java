package com.saludsystem.submodules.operaciones.model.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TipoMaterialDTO {

    private UUID tipoMaterialId;

    private String nombre;

    private String descripcion;

    @Schema(description = "Estado del tipo de material", example = "0")
    private Integer estado;

}
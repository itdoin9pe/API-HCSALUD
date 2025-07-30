package com.saludsystem.submodules.mantenimiento.dtos.post;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class CrearTarifarioDTO {

    private UUID tipoConceptoId;

    private UUID medidaId;

    private UUID categoriaId;

    private UUID unidadId;

    private String grupo;

    private String descripcion;

    @Schema(description = "Precio del tarifario", example = "0")
    private Double precio;

    @Schema(description = "Estado del tarifario (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}
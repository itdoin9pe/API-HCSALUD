package com.saludsystem.submodules.operaciones.dtos.put;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarUnidadDTO extends BaseDTO {

    private UUID unidadId;

    private String nombre;

    private String siglas;

    private String descripcion;

    @Schema(description = "estado de la unidad", example = "0")
    private Integer estado;

}
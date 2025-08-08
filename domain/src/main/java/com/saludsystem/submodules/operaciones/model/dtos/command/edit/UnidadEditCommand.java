package com.saludsystem.submodules.operaciones.model.dtos.command.edit;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UnidadEditCommand extends BaseDTO {

    private UUID unidadId;

    private String nombre;

    private String siglas;

    private String descripcion;

    @Schema(description = "estado de la unidad", example = "0")
    private Integer estado;

}
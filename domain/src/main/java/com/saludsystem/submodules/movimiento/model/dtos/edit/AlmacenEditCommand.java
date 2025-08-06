package com.saludsystem.submodules.movimiento.model.dtos.edit;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class AlmacenEditCommand extends BaseDTO {

    private UUID sedeId;

    private String nombre;

    @Schema(description = "Estado de almacen", example = "0")
    private Integer estado;
}

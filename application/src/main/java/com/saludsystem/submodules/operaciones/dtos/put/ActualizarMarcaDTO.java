package com.saludsystem.submodules.operaciones.dtos.put;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarMarcaDTO extends BaseDTO {

    private UUID marcaId;

    private String nombre;

    @Schema(description = "Estado de marca", example = "0")
    private Integer estado;

}

package com.saludsystem.application.operaciones.dtos.put;

import com.saludsystem.shared.application.dto.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarTipoMaterialDTO extends BaseDTO {

    private String nombre;

    private String descripcion;

    @Schema(description = "Estado del tipo de material", example = "0")
    private Integer estado;

}

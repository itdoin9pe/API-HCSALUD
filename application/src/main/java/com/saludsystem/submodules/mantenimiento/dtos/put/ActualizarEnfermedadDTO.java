package com.saludsystem.submodules.mantenimiento.dtos.put;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarEnfermedadDTO extends BaseDTO {
    private String enfermedadId;
    private String descripcion;
    @Schema(description = "Estado de Diagnostico (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;
}
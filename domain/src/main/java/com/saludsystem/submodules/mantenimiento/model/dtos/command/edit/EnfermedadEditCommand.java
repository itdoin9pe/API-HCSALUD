package com.saludsystem.submodules.mantenimiento.model.dtos.command.edit;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class EnfermedadEditCommand extends BaseDTO {
    private String enfermedadId;
    private String descripcion;
    @Schema(description = "Estado de Diagnostico (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;
}
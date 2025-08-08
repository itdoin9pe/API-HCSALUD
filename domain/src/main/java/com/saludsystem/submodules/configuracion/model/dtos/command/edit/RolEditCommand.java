package com.saludsystem.submodules.configuracion.model.dtos.command.edit;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RolEditCommand extends BaseDTO {
    private UUID roleId;
    @Schema(description = "Estado del rol (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;
    private String nombre;
}
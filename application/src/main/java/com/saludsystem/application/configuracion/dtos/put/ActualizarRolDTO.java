package com.saludsystem.application.configuracion.dtos.put;

import com.saludsystem.shared.application.dto.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarRolDTO extends BaseDTO {
    private UUID roleId;
    @Schema(description = "Estado del rol (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;
    private String nombre;
}
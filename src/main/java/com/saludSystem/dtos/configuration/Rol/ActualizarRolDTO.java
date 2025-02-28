package com.saludSystem.dtos.configuration.Rol;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.UUID;

@Data
public class ActualizarRolDTO {

    private UUID roleId;

    @Schema(description = "Estado del rol (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

    private String nombre;

}
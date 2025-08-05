package com.saludsystem.submodules.configuracion.model.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class RolDTO  {
    private UUID roleId;
    @Schema(description = "Estado del rol (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;
    private String nombre;

    public RolDTO(UUID roleId, String nombre, Integer estado) {
        this.setRoleId(roleId);
        this.setNombre(nombre);
        this.setEstado(estado);
    }

}
package com.saludsystem.submodules.configuracion.dtos.get;

import com.saludsystem.submodules.configuracion.dtos.post.CrearRolDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class RolDTO extends CrearRolDTO {
    private UUID roleId;
}
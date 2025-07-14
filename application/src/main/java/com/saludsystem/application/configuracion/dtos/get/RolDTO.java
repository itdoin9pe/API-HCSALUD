package com.saludsystem.application.configuracion.dtos.get;

import com.saludsystem.application.configuracion.dtos.post.CrearRolDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class RolDTO extends CrearRolDTO {
    private UUID roleId;
}
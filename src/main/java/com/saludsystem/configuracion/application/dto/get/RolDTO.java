package com.saludsystem.configuracion.application.dto.get;

import com.saludsystem.configuracion.application.dto.post.CrearRolDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class RolDTO extends CrearRolDTO {
    private UUID roleId;
}
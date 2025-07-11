package com.saludsystem.application.configuracion.dtos.get;

import com.configuracion.application.dto.post.CrearRolDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class RolDTO extends CrearRolDTO {
    private UUID roleId;
}
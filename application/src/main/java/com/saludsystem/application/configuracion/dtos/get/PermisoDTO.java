package com.saludsystem.application.configuracion.dtos.get;

import com.configuracion.application.dto.post.CrearPermisoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class PermisoDTO extends CrearPermisoDTO {
    private UUID permisoId;
}
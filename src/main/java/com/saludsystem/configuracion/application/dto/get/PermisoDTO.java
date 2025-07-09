package com.saludsystem.configuracion.application.dto.get;

import com.saludsystem.configuracion.application.dto.post.CrearPermisoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class PermisoDTO extends CrearPermisoDTO {
    private UUID permisoId;
}
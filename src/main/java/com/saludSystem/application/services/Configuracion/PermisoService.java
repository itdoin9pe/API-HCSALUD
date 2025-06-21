package com.saludSystem.application.services.Configuracion;

import com.saludSystem.application.dtos.Configuracion.GET.PermisoDTO;
import com.saludSystem.application.dtos.Configuracion.POST.CrearPermisoDTO;
import com.saludSystem.application.dtos.Configuracion.PUT.ActualizarPermisoDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface PermisoService extends GenericService<
        PermisoDTO,
        UUID,
        CrearPermisoDTO,
        ActualizarPermisoDTO> {
}
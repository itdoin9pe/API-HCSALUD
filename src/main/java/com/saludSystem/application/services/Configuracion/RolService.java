package com.saludSystem.application.services.Configuracion;

import com.saludSystem.application.dtos.Configuracion.PUT.ActualizarRolDTO;
import com.saludSystem.application.dtos.Configuracion.POST.CrearRolDTO;
import com.saludSystem.application.dtos.Configuracion.GET.RolDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface RolService extends GenericService<
        RolDTO,
        UUID,
        CrearRolDTO,
        ActualizarRolDTO> {
}
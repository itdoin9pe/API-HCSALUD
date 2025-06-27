package com.saludSystem.application.services.Operaciones;


import com.saludSystem.application.dtos.Operaciones.GET.ProveedorDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearProveedorDTO;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarProveedorDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface ProveedorService extends GenericService<
        ProveedorDTO,
        UUID,
        CrearProveedorDTO,
        ActualizarProveedorDTO> {
}
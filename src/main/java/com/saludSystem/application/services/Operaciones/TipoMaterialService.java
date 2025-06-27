package com.saludSystem.application.services.Operaciones;

import com.saludSystem.application.dtos.Operaciones.GET.TipoMaterialDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearTipoMaterialDTO;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarTipoMaterialDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface TipoMaterialService extends GenericService<
        TipoMaterialDTO,
        UUID,
        CrearTipoMaterialDTO,
        ActualizarTipoMaterialDTO> {
}
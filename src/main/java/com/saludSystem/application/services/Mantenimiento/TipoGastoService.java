package com.saludSystem.application.services.Mantenimiento;

import com.saludSystem.application.services.GenericService;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarTipoGastoDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearTipoGastoDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.TipoGastoDTO;

import java.util.UUID;

public interface TipoGastoService extends GenericService<
        TipoGastoDTO,
        UUID,
        CrearTipoGastoDTO,
        ActualizarTipoGastoDTO> {
}
package com.saludSystem.application.services.Mantenimiento;

import com.saludSystem.application.services.GenericService;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarTipoTarjetaDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearTipoTarjetaDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.TipoTarjetaDTO;

import java.util.UUID;

public interface TipoTarjetaService extends GenericService<TipoTarjetaDTO,
        UUID,
        CrearTipoTarjetaDTO,
        ActualizarTipoTarjetaDTO> {
}
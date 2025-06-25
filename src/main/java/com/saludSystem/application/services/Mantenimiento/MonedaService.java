package com.saludSystem.application.services.Mantenimiento;

import com.saludSystem.application.dtos.Mantenimiento.GET.MonedaDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearMonedaDTO;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarMonedaDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface MonedaService extends GenericService<
        MonedaDTO,
        UUID,
        CrearMonedaDTO,
        ActualizarMonedaDTO> {
}
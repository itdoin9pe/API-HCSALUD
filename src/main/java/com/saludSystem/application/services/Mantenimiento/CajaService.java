package com.saludSystem.application.services.Mantenimiento;

import com.saludSystem.application.services.GenericService;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarCajaDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.CajaDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearCajaDTO;

import java.util.UUID;

public interface CajaService extends GenericService<
        CajaDTO,
        UUID,
        CrearCajaDTO,
        ActualizarCajaDTO> {
}
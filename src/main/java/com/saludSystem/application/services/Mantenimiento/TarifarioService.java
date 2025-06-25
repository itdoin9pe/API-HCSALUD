package com.saludSystem.application.services.Mantenimiento;

import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarTarifarioDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearTarifarioDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.TarifarioDTO;

import java.util.List;
import java.util.UUID;

public interface TarifarioService extends GenericService<
        TarifarioDTO,
        UUID,
        CrearTarifarioDTO,
        ActualizarTarifarioDTO> {
}
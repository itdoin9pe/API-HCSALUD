package com.saludSystem.application.services.Mantenimiento;

import com.saludSystem.application.services.GenericService;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarTipoPagoDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearTipoPagoDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.TipoPagoDTO;

import java.util.UUID;

public interface TipoPagoService extends GenericService<
        TipoPagoDTO,
        UUID,
        CrearTipoPagoDTO,
        ActualizarTipoPagoDTO> {
}
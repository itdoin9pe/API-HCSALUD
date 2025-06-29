package com.saludSystem.application.services.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.PConsentimientoDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearPConsentimientoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarPConsentimiento;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface PConsentimientoService extends GenericService<
        PConsentimientoDTO,
        UUID,
        CrearPConsentimientoDTO,
        ActualizarPConsentimiento> {
}
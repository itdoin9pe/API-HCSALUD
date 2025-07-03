package com.saludsystem.application.services.paciente;

import com.saludsystem.application.dtos.paciente.get.PConsentimientoDTO;
import com.saludsystem.application.dtos.paciente.post.CrearPConsentimientoDTO;
import com.saludsystem.application.dtos.paciente.put.ActualizarPConsentimiento;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface PConsentimientoService extends GenericService<
        PConsentimientoDTO,
        UUID,
        CrearPConsentimientoDTO,
        ActualizarPConsentimiento> {
}
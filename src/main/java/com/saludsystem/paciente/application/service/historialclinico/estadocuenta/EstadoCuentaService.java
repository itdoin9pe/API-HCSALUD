package com.saludsystem.paciente.application.service.historialclinico.estadocuenta;

import com.saludsystem.paciente.application.dto.res.historialclinico.estadocuenta.EstadoCuentaResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.estadocuenta.EstadoCuentaRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface EstadoCuentaService extends GenericService<
        EstadoCuentaRequest,
        EstadoCuentaResponse,
        UUID> {
}
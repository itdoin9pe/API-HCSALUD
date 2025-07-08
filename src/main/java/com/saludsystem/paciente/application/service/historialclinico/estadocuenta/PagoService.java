package com.saludsystem.paciente.application.service.historialclinico.estadocuenta;

import com.saludsystem.paciente.application.dto.res.historialclinico.estadocuenta.PagoResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.estadocuenta.PagoRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface PagoService extends GenericService<
        PagoRequest,
        PagoResponse,
        UUID> {
}
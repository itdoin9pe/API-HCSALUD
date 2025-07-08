package com.saludsystem.paciente.application.service.historialclinico.estadocuenta;

import com.saludsystem.paciente.application.dto.res.historialclinico.estadocuenta.DetalleMedicamentoEstudioResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.estadocuenta.DetalleMedicamentoEstudioRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface DetalleMedicamentoEstudioService extends GenericService<
        DetalleMedicamentoEstudioRequest,
        DetalleMedicamentoEstudioResponse,
        UUID> {
}
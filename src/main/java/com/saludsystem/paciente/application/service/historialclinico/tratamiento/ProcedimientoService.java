package com.saludsystem.paciente.application.service.historialclinico.tratamiento;

import com.saludsystem.paciente.application.dto.res.historialclinico.tratamiento.ProcedimientoResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.tratamiento.ProcedimientoRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface ProcedimientoService extends GenericService<
        ProcedimientoRequest,
        ProcedimientoResponse,
        UUID> {
}
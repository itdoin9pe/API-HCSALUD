package com.saludsystem.paciente.application.service.historialclinico.tratamiento;

import com.saludsystem.paciente.application.dto.res.historialclinico.tratamiento.CostoTratamientoResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.tratamiento.CostoTratamientoRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface CostoTratamientoService extends GenericService<
        CostoTratamientoRequest,
        CostoTratamientoResponse,
        UUID> {
}
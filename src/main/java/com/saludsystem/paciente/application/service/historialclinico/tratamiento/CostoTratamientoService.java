package com.saludsystem.paciente.application.service.historialclinico.tratamiento;

import com.saludsystem.paciente.application.dto.res.historialclinico.tratamiento.CostoTratamientoDTO;
import com.saludsystem.paciente.application.dto.req.historialclinico.tratamiento.CrearCostoTratamientoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface CostoTratamientoService extends GenericService<
        CrearCostoTratamientoDTO,
        CostoTratamientoDTO,
        UUID> {
}
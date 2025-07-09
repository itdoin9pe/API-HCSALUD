package com.saludsystem.paciente.application.service.historialclinico.tratamiento;

import com.saludsystem.paciente.application.dto.get.historialclinico.tratamiento.CostoTratamientoDTO;
import com.saludsystem.paciente.application.dto.post.historialclinico.tratamiento.CrearCostoTratamientoDTO;
import com.saludsystem.paciente.application.dto.put.historialclinico.tratamiento.ActualizarCostoTratamientoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface CostoTratamientoService extends GenericService<
        CostoTratamientoDTO,
        CrearCostoTratamientoDTO,
        ActualizarCostoTratamientoDTO,
        UUID> {
}
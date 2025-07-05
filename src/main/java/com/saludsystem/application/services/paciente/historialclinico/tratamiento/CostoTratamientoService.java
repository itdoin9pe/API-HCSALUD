package com.saludsystem.application.services.paciente.historialclinico.tratamiento;

import com.saludsystem.application.dtos.paciente.get.historialclinico.tratamiento.CostoTratamientoDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.tratamiento.CrearCostoTratamientoDTO;
import com.saludsystem.application.dtos.paciente.put.historialclinico.tratamiento.ActualizarCostoTratamientoDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface CostoTratamientoService extends GenericService<
        CostoTratamientoDTO,
        UUID,
        CrearCostoTratamientoDTO,
        ActualizarCostoTratamientoDTO> {
}
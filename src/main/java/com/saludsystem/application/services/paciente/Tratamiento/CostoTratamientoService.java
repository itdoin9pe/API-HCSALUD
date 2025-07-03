package com.saludsystem.application.services.paciente.Tratamiento;

import com.saludsystem.application.dtos.paciente.get.tratamiento.CostoTratamientoDTO;
import com.saludsystem.application.dtos.paciente.post.tratamiento.CrearCostoTratamientoDTO;
import com.saludsystem.application.dtos.paciente.put.tratamiento.ActualizarCostoTratamientoDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface CostoTratamientoService extends GenericService<
        CostoTratamientoDTO,
        UUID,
        CrearCostoTratamientoDTO,
        ActualizarCostoTratamientoDTO> {
}
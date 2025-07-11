package com.saludsystem.domain.paciente.port.in.service.historialclinico.tratamiento;

import com.saludsystem.application.dto.get.historialclinico.tratamiento.CostoTratamientoDTO;
import com.saludsystem.application.dto.post.historialclinico.tratamiento.CrearCostoTratamientoDTO;
import com.saludsystem.application.dto.put.historialclinico.tratamiento.ActualizarCostoTratamientoDTO;
import com.configuracion.application.services.GenericService;

import java.util.UUID;

public interface CostoTratamientoService extends GenericService<
        CostoTratamientoDTO,
        CrearCostoTratamientoDTO,
        ActualizarCostoTratamientoDTO,
        UUID> {
}
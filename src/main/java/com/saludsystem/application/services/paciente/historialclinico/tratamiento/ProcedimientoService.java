package com.saludsystem.application.services.paciente.historialclinico.tratamiento;

import com.saludsystem.application.dtos.paciente.get.historialclinico.tratamiento.ProcedimientoDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.tratamiento.CrearProcedimientoDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface ProcedimientoService extends GenericService<
        CrearProcedimientoDTO,
        ProcedimientoDTO,
        UUID> {
}
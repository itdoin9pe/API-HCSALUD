package com.saludsystem.paciente.application.service.historialclinico.tratamiento;

import com.saludsystem.paciente.application.dto.get.historialclinico.tratamiento.ProcedimientoDTO;
import com.saludsystem.paciente.application.dto.post.historialclinico.tratamiento.CrearProcedimientoDTO;
import com.saludsystem.paciente.application.dto.put.historialclinico.tratamiento.ActualizarProcedimientoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface ProcedimientoService extends GenericService<
        ProcedimientoDTO,
        CrearProcedimientoDTO,
        ActualizarProcedimientoDTO,
        UUID> {
}
package com.saludsystem.domain.paciente.port.in.service.historialclinico.tratamiento;

import com.saludsystem.application.dto.get.historialclinico.tratamiento.ProcedimientoDTO;
import com.saludsystem.application.dto.post.historialclinico.tratamiento.CrearProcedimientoDTO;
import com.saludsystem.application.dto.put.historialclinico.tratamiento.ActualizarProcedimientoDTO;
import com.configuracion.application.services.GenericService;

import java.util.UUID;

public interface ProcedimientoService extends GenericService<
        ProcedimientoDTO,
        CrearProcedimientoDTO,
        ActualizarProcedimientoDTO,
        UUID> {
}
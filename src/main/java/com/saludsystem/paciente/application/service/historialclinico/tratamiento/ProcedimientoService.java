package com.saludsystem.paciente.application.service.historialclinico.tratamiento;

import com.saludsystem.paciente.application.dto.res.historialclinico.tratamiento.ProcedimientoDTO;
import com.saludsystem.paciente.application.dto.req.historialclinico.tratamiento.CrearProcedimientoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface ProcedimientoService extends GenericService<
        CrearProcedimientoDTO,
        ProcedimientoDTO,
        UUID> {
}
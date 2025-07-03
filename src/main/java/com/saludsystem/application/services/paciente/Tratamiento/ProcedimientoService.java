package com.saludsystem.application.services.paciente.Tratamiento;

import com.saludsystem.application.dtos.paciente.get.tratamiento.ProcedimientoDTO;
import com.saludsystem.application.dtos.paciente.post.tratamiento.CrearProcedimientoDTO;
import com.saludsystem.application.dtos.paciente.put.tratamiento.ActualizarProcedimientoDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface ProcedimientoService extends GenericService<
        ProcedimientoDTO,
        UUID,
        CrearProcedimientoDTO,
        ActualizarProcedimientoDTO> {
}
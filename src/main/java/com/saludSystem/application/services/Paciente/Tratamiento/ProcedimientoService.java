package com.saludSystem.application.services.Paciente.Tratamiento;

import com.saludSystem.application.dtos.Paciente.GET.Tratamiento.ProcedimientoDTO;
import com.saludSystem.application.dtos.Paciente.POST.Tratamiento.CrearProcedimientoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.Tratamiento.ActualizarProcedimientoDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface ProcedimientoService extends GenericService<
        ProcedimientoDTO,
        UUID,
        CrearProcedimientoDTO,
        ActualizarProcedimientoDTO> {
}
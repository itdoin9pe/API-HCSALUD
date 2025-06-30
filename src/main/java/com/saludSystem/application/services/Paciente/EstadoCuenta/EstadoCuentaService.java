package com.saludSystem.application.services.Paciente.EstadoCuenta;

import com.saludSystem.application.dtos.Paciente.GET.EstadoCuenta.EstadoCuentaDTO;
import com.saludSystem.application.dtos.Paciente.POST.EstadoCuenta.CrearEstadoCuentaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.EstadoCuenta.ActualizarEstadoCuentaDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface EstadoCuentaService extends GenericService<
        EstadoCuentaDTO,
        UUID,
        CrearEstadoCuentaDTO,
        ActualizarEstadoCuentaDTO> {
}
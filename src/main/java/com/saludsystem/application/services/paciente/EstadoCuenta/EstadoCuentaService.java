package com.saludsystem.application.services.paciente.EstadoCuenta;

import com.saludsystem.application.dtos.paciente.get.estadocuenta.EstadoCuentaDTO;
import com.saludsystem.application.dtos.paciente.post.estadocuenta.CrearEstadoCuentaDTO;
import com.saludsystem.application.dtos.paciente.put.estadocuenta.ActualizarEstadoCuentaDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface EstadoCuentaService extends GenericService<
        EstadoCuentaDTO,
        UUID,
        CrearEstadoCuentaDTO,
        ActualizarEstadoCuentaDTO> {
}
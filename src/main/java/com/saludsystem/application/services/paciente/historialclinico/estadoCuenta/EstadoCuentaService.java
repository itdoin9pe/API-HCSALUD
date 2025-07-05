package com.saludsystem.application.services.paciente.historialclinico.estadoCuenta;

import com.saludsystem.application.dtos.paciente.get.historialclinico.estadocuenta.EstadoCuentaDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.estadocuenta.CrearEstadoCuentaDTO;
import com.saludsystem.application.dtos.paciente.put.historialclinico.estadocuenta.ActualizarEstadoCuentaDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface EstadoCuentaService extends GenericService<
        EstadoCuentaDTO,
        UUID,
        CrearEstadoCuentaDTO,
        ActualizarEstadoCuentaDTO> {
}
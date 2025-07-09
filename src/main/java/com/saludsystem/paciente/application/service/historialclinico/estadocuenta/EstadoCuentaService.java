package com.saludsystem.paciente.application.service.historialclinico.estadocuenta;

import com.saludsystem.paciente.application.dto.get.historialclinico.estadocuenta.EstadoCuentaDTO;
import com.saludsystem.paciente.application.dto.post.historialclinico.estadocuenta.CrearEstadoCuentaDTO;
import com.saludsystem.paciente.application.dto.put.historialclinico.estadocuenta.ActualizarEstadoCuentaDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface EstadoCuentaService extends GenericService<
        EstadoCuentaDTO,
        CrearEstadoCuentaDTO,
        ActualizarEstadoCuentaDTO,
        UUID> {
}
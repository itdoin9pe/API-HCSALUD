package com.saludsystem.domain.paciente.port.in.service.historialclinico.estadocuenta;

import com.saludsystem.application.dto.get.historialclinico.estadocuenta.EstadoCuentaDTO;
import com.saludsystem.application.dto.post.historialclinico.estadocuenta.CrearEstadoCuentaDTO;
import com.saludsystem.application.dto.put.historialclinico.estadocuenta.ActualizarEstadoCuentaDTO;
import com.configuracion.application.services.GenericService;

import java.util.UUID;

public interface EstadoCuentaService extends GenericService<
        EstadoCuentaDTO,
        CrearEstadoCuentaDTO,
        ActualizarEstadoCuentaDTO,
        UUID> {
}
package com.saludsystem.domain.paciente.port.in.service.historialclinico.estadocuenta;

import com.saludsystem.application.dto.get.historialclinico.estadocuenta.PagoDTO;
import com.saludsystem.application.dto.post.historialclinico.estadocuenta.CrearPagoDTO;
import com.saludsystem.application.dto.put.historialclinico.estadocuenta.ActualizarPagoDTO;
import com.configuracion.application.services.GenericService;

import java.util.UUID;

public interface PagoService extends GenericService<
        PagoDTO,
        CrearPagoDTO,
        ActualizarPagoDTO,
        UUID> {
}
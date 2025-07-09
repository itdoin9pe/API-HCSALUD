package com.saludsystem.paciente.application.service.historialclinico.estadocuenta;

import com.saludsystem.paciente.application.dto.get.historialclinico.estadocuenta.PagoDTO;
import com.saludsystem.paciente.application.dto.post.historialclinico.estadocuenta.CrearPagoDTO;
import com.saludsystem.paciente.application.dto.put.historialclinico.estadocuenta.ActualizarPagoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface PagoService extends GenericService<
        PagoDTO,
        CrearPagoDTO,
        ActualizarPagoDTO,
        UUID> {
}
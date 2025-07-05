package com.saludsystem.application.services.paciente.historialclinico.estadocuenta;

import com.saludsystem.application.dtos.paciente.get.historialclinico.estadocuenta.PagoDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.estadocuenta.CrearPagoDTO;
import com.saludsystem.application.dtos.paciente.put.historialclinico.estadocuenta.ActualizarPagoDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface PagoService extends GenericService<
        PagoDTO,
        UUID,
        CrearPagoDTO,
        ActualizarPagoDTO> {
}
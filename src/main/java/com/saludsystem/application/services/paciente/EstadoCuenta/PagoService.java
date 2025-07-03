package com.saludsystem.application.services.paciente.EstadoCuenta;

import com.saludsystem.application.dtos.paciente.get.estadocuenta.PagoDTO;
import com.saludsystem.application.dtos.paciente.post.estadocuenta.CrearPagoDTO;
import com.saludsystem.application.dtos.paciente.put.estadocuenta.ActualizarPagoDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface PagoService extends GenericService<
        PagoDTO,
        UUID,
        CrearPagoDTO,
        ActualizarPagoDTO> {
}
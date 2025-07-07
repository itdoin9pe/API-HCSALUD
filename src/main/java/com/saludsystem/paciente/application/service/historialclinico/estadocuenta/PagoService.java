package com.saludsystem.paciente.application.service.historialclinico.estadocuenta;

import com.saludsystem.paciente.application.dto.res.historialclinico.estadocuenta.PagoDTO;
import com.saludsystem.paciente.application.dto.req.historialclinico.estadocuenta.CrearPagoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface PagoService extends GenericService<
        CrearPagoDTO,
        PagoDTO,
        UUID> {
}
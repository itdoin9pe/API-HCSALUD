package com.saludSystem.application.services.Paciente.EstadoCuenta;

import com.saludSystem.application.dtos.Paciente.GET.EstadoCuenta.PagoDTO;
import com.saludSystem.application.dtos.Paciente.POST.EstadoCuenta.CrearPagoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.EstadoCuenta.ActualizarPagoDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface PagoService extends GenericService<
        PagoDTO,
        UUID,
        CrearPagoDTO,
        ActualizarPagoDTO> {
}
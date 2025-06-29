package com.saludSystem.application.services.Paciente.EstadoCuenta;

import com.saludSystem.application.dtos.Paciente.GET.EstadoCuenta.DetalleMedicamentoEstudioDTO;
import com.saludSystem.application.dtos.Paciente.POST.EstadoCuenta.CrearDetalleMedicamentoEstudioDTO;
import com.saludSystem.application.dtos.Paciente.PUT.EstadoCuenta.ActualizarDetalleMedicamentoEstudioDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface DetalleMedicamentoEstudioService extends GenericService<
        DetalleMedicamentoEstudioDTO,
        UUID,
        CrearDetalleMedicamentoEstudioDTO,
        ActualizarDetalleMedicamentoEstudioDTO> {
}
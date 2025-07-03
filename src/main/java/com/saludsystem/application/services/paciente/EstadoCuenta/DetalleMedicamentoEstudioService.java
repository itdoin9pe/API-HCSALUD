package com.saludsystem.application.services.paciente.EstadoCuenta;

import com.saludsystem.application.dtos.paciente.get.estadocuenta.DetalleMedicamentoEstudioDTO;
import com.saludsystem.application.dtos.paciente.post.estadocuenta.CrearDetalleMedicamentoEstudioDTO;
import com.saludsystem.application.dtos.paciente.put.estadocuenta.ActualizarDetalleMedicamentoEstudioDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface DetalleMedicamentoEstudioService extends GenericService<
        DetalleMedicamentoEstudioDTO,
        UUID,
        CrearDetalleMedicamentoEstudioDTO,
        ActualizarDetalleMedicamentoEstudioDTO> {
}
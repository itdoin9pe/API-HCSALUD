package com.saludsystem.application.services.paciente.historialclinico.estadocuenta;

import com.saludsystem.application.dtos.paciente.get.historialclinico.estadocuenta.DetalleMedicamentoEstudioDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.estadocuenta.CrearDetalleMedicamentoEstudioDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface DetalleMedicamentoEstudioService extends GenericService<
        CrearDetalleMedicamentoEstudioDTO,
        DetalleMedicamentoEstudioDTO,
        UUID> {
}
package com.saludsystem.paciente.application.service.historialclinico.estadocuenta;

import com.saludsystem.paciente.application.dto.get.historialclinico.estadocuenta.DetalleMedicamentoEstudioDTO;
import com.saludsystem.paciente.application.dto.post.historialclinico.estadocuenta.CrearDetalleMedicamentoEstudioDTO;
import com.saludsystem.paciente.application.dto.put.historialclinico.estadocuenta.ActualizarDetalleMedicamentoEstudioDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface DetalleMedicamentoEstudioService extends GenericService<
        DetalleMedicamentoEstudioDTO,
        CrearDetalleMedicamentoEstudioDTO,
        ActualizarDetalleMedicamentoEstudioDTO,
        UUID> {
}
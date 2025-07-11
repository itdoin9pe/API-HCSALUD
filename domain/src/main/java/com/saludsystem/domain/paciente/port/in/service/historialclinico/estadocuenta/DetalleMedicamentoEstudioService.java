package com.saludsystem.domain.paciente.port.in.service.historialclinico.estadocuenta;

import com.saludsystem.application.dto.get.historialclinico.estadocuenta.DetalleMedicamentoEstudioDTO;
import com.saludsystem.application.dto.post.historialclinico.estadocuenta.CrearDetalleMedicamentoEstudioDTO;
import com.saludsystem.application.dto.put.historialclinico.estadocuenta.ActualizarDetalleMedicamentoEstudioDTO;
import com.configuracion.application.services.GenericService;

import java.util.UUID;

public interface DetalleMedicamentoEstudioService extends GenericService<
        DetalleMedicamentoEstudioDTO,
        CrearDetalleMedicamentoEstudioDTO,
        ActualizarDetalleMedicamentoEstudioDTO,
        UUID> {
}
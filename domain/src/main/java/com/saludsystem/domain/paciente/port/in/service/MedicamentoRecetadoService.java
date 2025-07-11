package com.saludsystem.domain.paciente.port.in.service;

import com.saludsystem.application.dto.get.MedicamentoRecetadoDTO;
import com.saludsystem.application.dto.post.CrearMedicamentoRecetadoDTO;
import com.saludsystem.application.dto.put.ActualizarMedicamentoRecetadoDTO;
import com.configuracion.application.services.GenericService;

import java.util.UUID;

public interface MedicamentoRecetadoService extends GenericService<
        MedicamentoRecetadoDTO,
        CrearMedicamentoRecetadoDTO,
        ActualizarMedicamentoRecetadoDTO,
        UUID> {
}
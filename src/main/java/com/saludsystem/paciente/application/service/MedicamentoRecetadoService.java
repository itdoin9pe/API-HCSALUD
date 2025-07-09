package com.saludsystem.paciente.application.service;

import com.saludsystem.paciente.application.dto.get.MedicamentoRecetadoDTO;
import com.saludsystem.paciente.application.dto.post.CrearMedicamentoRecetadoDTO;
import com.saludsystem.paciente.application.dto.put.ActualizarMedicamentoRecetadoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface MedicamentoRecetadoService extends GenericService<
        MedicamentoRecetadoDTO,
        CrearMedicamentoRecetadoDTO,
        ActualizarMedicamentoRecetadoDTO,
        UUID> {
}
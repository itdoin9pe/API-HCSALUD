package com.saludsystem.paciente.application.service;

import com.saludsystem.paciente.application.dto.res.MedicamentoRecetadoDTO;
import com.saludsystem.paciente.application.dto.req.CrearMedicamentoRecetadoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface MedicamentoRecetadoService extends GenericService<
        CrearMedicamentoRecetadoDTO,
        MedicamentoRecetadoDTO,
        UUID> {
}
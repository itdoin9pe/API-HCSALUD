package com.saludsystem.paciente.application.service;

import com.saludsystem.paciente.application.dto.res.MedicamentoRecetadoResponse;
import com.saludsystem.paciente.application.dto.req.MedicamentoRecetadoRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface MedicamentoRecetadoService extends GenericService<
        MedicamentoRecetadoRequest,
        MedicamentoRecetadoResponse,
        UUID> {
}
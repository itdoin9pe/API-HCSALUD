package com.saludsystem.domain.paciente.port.in.service;

import com.saludsystem.domain.paciente.model.MedicamentoRecetado;

import java.util.List;
import java.util.UUID;

public interface MedicamentoRecetadoService {
    MedicamentoRecetado save(MedicamentoRecetado medicamentoRecetado);
    MedicamentoRecetado update(UUID uuid, MedicamentoRecetado medicamentoRecetado);
    void delete(UUID uuid);
    MedicamentoRecetado getById(UUID uuid);
    List<MedicamentoRecetado> getAll(UUID hospitalId, int page, int rows);
}
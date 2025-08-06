package com.saludsystem.submodules.paciente.port.repository;

import com.saludsystem.submodules.paciente.model.entity.MedicamentoRecetado;

import java.util.UUID;

public interface MedicamentoRecetadoRepository {
    MedicamentoRecetado save(MedicamentoRecetado medicamentoRecetado);
    MedicamentoRecetado update(UUID uuid, MedicamentoRecetado medicamentoRecetado);
    void delete(UUID uuid);
}
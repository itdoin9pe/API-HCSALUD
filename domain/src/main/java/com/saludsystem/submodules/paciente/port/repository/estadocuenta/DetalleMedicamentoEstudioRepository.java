package com.saludsystem.submodules.paciente.port.repository.estadocuenta;

import com.saludsystem.submodules.paciente.model.entity.estadocuenta.DetalleMedicamentoEstudio;

import java.util.UUID;

public interface DetalleMedicamentoEstudioRepository {
    DetalleMedicamentoEstudio save(DetalleMedicamentoEstudio detalleMedicamentoEstudio);
    DetalleMedicamentoEstudio update(UUID uuid, DetalleMedicamentoEstudio detalleMedicamentoEstudio);
    void delete(UUID uuid);
}
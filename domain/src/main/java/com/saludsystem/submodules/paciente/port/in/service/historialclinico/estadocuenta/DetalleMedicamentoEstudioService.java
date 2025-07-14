package com.saludsystem.submodules.paciente.port.in.service.historialclinico.estadocuenta;

import com.saludsystem.submodules.paciente.model.historialclinico.estadocuenta.DetalleMedicamentoEstudio;

import java.util.List;
import java.util.UUID;

public interface DetalleMedicamentoEstudioService {
    DetalleMedicamentoEstudio save(DetalleMedicamentoEstudio detalleMedicamentoEstudio);
    DetalleMedicamentoEstudio update(UUID uuid, DetalleMedicamentoEstudio detalleMedicamentoEstudio);
    void delete(UUID uuid);
    DetalleMedicamentoEstudio getById(UUID uuid);
    List<DetalleMedicamentoEstudio> getAll(UUID hospitalId, int page, int rows);
}
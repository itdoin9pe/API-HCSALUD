package com.saludsystem.submodules.paciente.port.dao.historialclinico.estadocuenta;

import com.saludsystem.submodules.paciente.model.entity.estadocuenta.DetalleMedicamentoEstudio;

import java.util.List;
import java.util.UUID;

public interface DetalleMedicamentoEstudioDao {
    DetalleMedicamentoEstudio save(DetalleMedicamentoEstudio detalleMedicamentoEstudio);
    DetalleMedicamentoEstudio update(UUID uuid, DetalleMedicamentoEstudio detalleMedicamentoEstudio);
    void delete(UUID uuid);
    DetalleMedicamentoEstudio getById(UUID uuid);
    List<DetalleMedicamentoEstudio> getAll(UUID hospitalId, int page, int rows);
}
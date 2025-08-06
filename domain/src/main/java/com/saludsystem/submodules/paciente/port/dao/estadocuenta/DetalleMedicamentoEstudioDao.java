package com.saludsystem.submodules.paciente.port.dao.estadocuenta;

import com.saludsystem.submodules.paciente.model.entity.estadocuenta.DetalleMedicamentoEstudio;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface DetalleMedicamentoEstudioDao {
    DetalleMedicamentoEstudio getById(UUID uuid);
    ListResponse<DetalleMedicamentoEstudio> getAll(UUID hospitalId, int page, int rows);
    List<DetalleMedicamentoEstudio> getList();
}
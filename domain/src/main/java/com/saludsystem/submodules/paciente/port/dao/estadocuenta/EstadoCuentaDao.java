package com.saludsystem.submodules.paciente.port.dao.estadocuenta;

import com.saludsystem.submodules.paciente.model.entity.estadocuenta.EstadoCuenta;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface EstadoCuentaDao {
    EstadoCuenta getById(UUID uuid);
    ListResponse<EstadoCuenta> getAll(UUID hospitalId, int page, int rows);
    List<EstadoCuenta> getList();
}
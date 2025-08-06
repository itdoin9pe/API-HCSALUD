package com.saludsystem.submodules.paciente.port.dao.estadocuenta;

import com.saludsystem.submodules.paciente.model.entity.estadocuenta.Pago;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface PagoDao {
    Pago getById(UUID uuid);
    ListResponse<Pago> getAll(UUID hospitalId, int page, int rows);
    List<Pago> getList();
}
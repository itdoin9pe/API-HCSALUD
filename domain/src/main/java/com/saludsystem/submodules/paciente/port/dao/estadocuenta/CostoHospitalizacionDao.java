package com.saludsystem.submodules.paciente.port.dao.estadocuenta;

import com.saludsystem.submodules.paciente.model.entity.estadocuenta.CostoHospitalizacion;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface CostoHospitalizacionDao {
    CostoHospitalizacion getById(UUID uuid);
    ListResponse<CostoHospitalizacion> getAll(UUID hospitalId, int page, int rows);
    List<CostoHospitalizacion> getList();
}
package com.saludsystem.submodules.paciente.port.dao.historialclinico.estadocuenta;

import com.saludsystem.submodules.paciente.model.entity.estadocuenta.CostoHospitalizacion;

import java.util.List;
import java.util.UUID;

public interface CostoHospitalizacionDao {
    CostoHospitalizacion save(CostoHospitalizacion costoHospitalizacion);
    CostoHospitalizacion update(UUID uuid, CostoHospitalizacion costoHospitalizacion);
    void delete(UUID uuid);
    CostoHospitalizacion getById(UUID uuid);
    List<CostoHospitalizacion> getAll(UUID hospitalId, int page, int rows);
}
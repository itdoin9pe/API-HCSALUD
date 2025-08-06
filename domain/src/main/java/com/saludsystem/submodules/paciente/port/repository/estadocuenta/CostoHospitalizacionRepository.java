package com.saludsystem.submodules.paciente.port.repository.estadocuenta;

import com.saludsystem.submodules.paciente.model.entity.estadocuenta.CostoHospitalizacion;

import java.util.UUID;

public interface CostoHospitalizacionRepository {
    CostoHospitalizacion save(CostoHospitalizacion costoHospitalizacion);
    CostoHospitalizacion update(UUID uuid, CostoHospitalizacion costoHospitalizacion);
    void delete(UUID uuid);
}
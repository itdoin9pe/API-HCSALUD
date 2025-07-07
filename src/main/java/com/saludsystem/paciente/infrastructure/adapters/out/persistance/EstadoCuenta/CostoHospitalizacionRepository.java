package com.saludsystem.paciente.infrastructure.adapters.out.persistance.EstadoCuenta;

import com.saludsystem.paciente.domain.model.EstadoCuenta.CostoHospitalizacionEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostoHospitalizacionRepository extends GenericRepository<CostoHospitalizacionEntity> {
}
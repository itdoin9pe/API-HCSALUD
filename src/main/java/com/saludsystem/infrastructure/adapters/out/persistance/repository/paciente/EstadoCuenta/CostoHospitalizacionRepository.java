package com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.EstadoCuenta;

import com.saludsystem.domain.model.paciente.EstadoCuenta.CostoHospitalizacionEntity;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostoHospitalizacionRepository extends GenericRepository<CostoHospitalizacionEntity> {
}
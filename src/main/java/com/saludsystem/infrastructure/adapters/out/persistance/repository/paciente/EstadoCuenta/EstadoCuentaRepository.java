package com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.EstadoCuenta;

import com.saludsystem.domain.model.paciente.EstadoCuenta.EstadoCuentaEntity;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoCuentaRepository extends GenericRepository<EstadoCuentaEntity> {

}
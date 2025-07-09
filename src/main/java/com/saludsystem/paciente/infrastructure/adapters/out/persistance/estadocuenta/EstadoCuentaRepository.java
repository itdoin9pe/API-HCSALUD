package com.saludsystem.paciente.infrastructure.adapters.out.persistance.estadocuenta;

import com.saludsystem.paciente.domain.model.estadocuenta.EstadoCuentaEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoCuentaRepository extends GenericRepository<EstadoCuentaEntity> {

}
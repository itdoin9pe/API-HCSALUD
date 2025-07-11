package com.saludsystem.infrastructure.adapter.jparepository.paciente.historialclinico.estadocuenta;

import com.saludsystem.domain.model.estadocuenta.EstadoCuentaEntity;
import com.configuracion.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoCuentaRepositoryPort extends GenericRepository<EstadoCuentaEntity> {

}
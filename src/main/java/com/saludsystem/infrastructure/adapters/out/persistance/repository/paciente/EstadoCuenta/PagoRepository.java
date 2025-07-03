package com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.EstadoCuenta;

import com.saludsystem.domain.model.paciente.EstadoCuenta.PagoEntity;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends GenericRepository<PagoEntity> {

}
package com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.EstadoCuenta;

import com.saludSystem.domain.model.Paciente.EstadoCuenta.PagoEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends GenericRepository<PagoEntity> {

}
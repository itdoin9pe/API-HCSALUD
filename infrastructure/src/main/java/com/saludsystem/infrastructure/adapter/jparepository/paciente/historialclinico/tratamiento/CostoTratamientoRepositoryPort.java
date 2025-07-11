package com.saludsystem.infrastructure.adapter.jparepository.paciente.historialclinico.tratamiento;

import com.saludsystem.domain.model.tratamiento.CostoTratamientoEntity;
import com.configuracion.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostoTratamientoRepositoryPort extends GenericRepository<CostoTratamientoEntity> {

}
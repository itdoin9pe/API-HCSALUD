package com.saludsystem.infrastructure.adapter.jparepository.principal;

import com.saludsystem.domain.model.InformacionClinicaEntity;
import com.configuracion.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformacionClinicaRepositoryPort extends GenericRepository<InformacionClinicaEntity> {

}
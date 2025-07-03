package com.saludsystem.infrastructure.adapters.out.persistance.repository.principal;

import com.saludsystem.domain.model.principal.InformacionClinicaEntity;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformacionClinicaRepository extends GenericRepository<InformacionClinicaEntity> {

}
package com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion;

import com.saludSystem.domain.model.Configuracion.SedeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SedeRepository extends JpaRepository<SedeEntity, UUID> {

    List<SedeEntity> findByHospital_HospitalId(UUID hospitalId);

    Page<SedeEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
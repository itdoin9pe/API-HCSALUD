package com.saludsystem.infrastructure.adapter.jparepository.paciente.historialclinico.evolucion;

import com.saludsystem.domain.model.evolucion.AltaMedicaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AltaMedicaRepository extends JpaRepository<AltaMedicaEntity, Long> {
    Page<AltaMedicaEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}
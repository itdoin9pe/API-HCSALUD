package com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.Evolucion;

import com.saludsystem.domain.model.paciente.Evolucion.AltaMedicaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AltaMedicaRepository extends JpaRepository<AltaMedicaEntity, Long> {
    Page<AltaMedicaEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}
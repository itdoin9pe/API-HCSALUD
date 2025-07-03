package com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.Evolucion;

import com.saludsystem.domain.model.paciente.Evolucion.EvolucionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EvolucionRepository extends JpaRepository<EvolucionEntity, UUID> {
    Page<EvolucionEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}
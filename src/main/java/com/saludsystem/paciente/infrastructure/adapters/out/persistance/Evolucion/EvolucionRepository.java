package com.saludsystem.paciente.infrastructure.adapters.out.persistance.Evolucion;

import com.saludsystem.paciente.domain.model.Evolucion.EvolucionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EvolucionRepository extends JpaRepository<EvolucionEntity, UUID> {
    Page<EvolucionEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}
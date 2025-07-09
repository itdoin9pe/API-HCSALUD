package com.saludsystem.paciente.infrastructure.adapters.out.persistance.evolucion;

import com.saludsystem.paciente.domain.model.evolucion.NotaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NotaRepository extends JpaRepository<NotaEntity, Long> {
    Page<NotaEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}
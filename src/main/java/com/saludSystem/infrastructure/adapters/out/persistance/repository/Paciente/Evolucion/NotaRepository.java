package com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.Evolucion;

import com.saludSystem.domain.model.Paciente.Evolucion.NotaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NotaRepository extends JpaRepository<NotaEntity, Long> {
    Page<NotaEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}
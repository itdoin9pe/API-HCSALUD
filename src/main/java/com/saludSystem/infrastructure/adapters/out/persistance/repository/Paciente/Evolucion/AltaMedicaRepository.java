package com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.Evolucion;

import com.saludSystem.domain.model.Paciente.Evolucion.AltaMedicaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AltaMedicaRepository extends JpaRepository<AltaMedicaEntity, Long> {

    Page<AltaMedicaEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
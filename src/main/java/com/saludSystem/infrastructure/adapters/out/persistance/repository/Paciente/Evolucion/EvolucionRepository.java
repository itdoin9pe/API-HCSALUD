package com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.Evolucion;

import com.saludSystem.domain.model.Paciente.Evolucion.EvolucionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EvolucionRepository extends JpaRepository<EvolucionEntity, UUID> {

    Page<EvolucionEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}

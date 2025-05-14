package com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente;

import com.saludSystem.domain.model.Paciente.PacienteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity, UUID> {

    Page<PacienteEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
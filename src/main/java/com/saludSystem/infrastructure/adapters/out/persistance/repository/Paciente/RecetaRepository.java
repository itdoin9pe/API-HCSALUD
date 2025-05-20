package com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente;

import com.saludSystem.domain.model.Paciente.RecetaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RecetaRepository extends JpaRepository<RecetaEntity, UUID> {

    Page<RecetaEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
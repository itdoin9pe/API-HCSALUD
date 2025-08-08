package com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces;

import com.saludsystem.submodules.core.paciente.adapter.entity.PacienteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface PacienteJpaRepository extends JpaRepository<PacienteEntity, UUID> {

    Page<PacienteEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
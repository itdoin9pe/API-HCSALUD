package com.saludsystem.submodules.adapter.jpa.interfaces.paciente;

import com.saludsystem.submodules.adapter.entity.paciente.PacienteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface PacienteJpaRepository extends JpaRepository<PacienteEntity, UUID> {

    Page<PacienteEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
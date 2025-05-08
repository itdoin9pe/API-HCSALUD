package com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.HistorialClinico;

import com.saludSystem.domain.model.Paciente.HistorialClinico.PacienteAlergiaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PacienteAlergiaRepository extends JpaRepository<PacienteAlergiaEntity, UUID> {

    Page<PacienteAlergiaEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
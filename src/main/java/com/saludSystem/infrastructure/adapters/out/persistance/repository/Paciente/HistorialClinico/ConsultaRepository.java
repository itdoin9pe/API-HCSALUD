package com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.HistorialClinico;

import com.saludSystem.domain.model.Paciente.HistorialClinico.ConsultaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaEntity, UUID> {

    Page<ConsultaEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
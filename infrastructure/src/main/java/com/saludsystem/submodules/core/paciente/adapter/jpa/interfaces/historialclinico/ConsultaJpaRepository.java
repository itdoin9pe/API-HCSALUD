package com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.historialclinico;

import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.ConsultaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConsultaJpaRepository extends JpaRepository<ConsultaEntity, UUID> {
    Page<ConsultaEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}
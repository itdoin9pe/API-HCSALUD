package com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saludsystem.submodules.core.paciente.adapter.entity.DiagnosticoEntity;

@Repository
public interface DiagnosticoJpaRepository extends JpaRepository<DiagnosticoEntity, UUID>
{
	Page<DiagnosticoEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}
package com.saludsystem.submodules.sections.paciente.adapter.jpa.inter.historialclinico.evolucion;

import com.saludsystem.submodules.sections.paciente.adapter.entity.historialclinico.evolucion.NotaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NotaJpaRepository extends JpaRepository<NotaEntity, Long> {
    Page<NotaEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}
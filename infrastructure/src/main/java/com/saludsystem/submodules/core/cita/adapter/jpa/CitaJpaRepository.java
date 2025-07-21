package com.saludsystem.submodules.core.cita.adapter.jpa;

import com.saludsystem.submodules.core.cita.adapter.entity.CitaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CitaJpaRepository extends JpaRepository<CitaEntity, UUID> {

    Page<CitaEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
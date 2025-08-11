package com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.historialclinico;

import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.ExploracionFisicaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExploracionFisicaJpaRepository extends JpaRepository<ExploracionFisicaEntity, UUID> {
    Page<ExploracionFisicaEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}
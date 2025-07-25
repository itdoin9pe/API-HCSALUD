package com.saludsystem.submodules.core.principal.adapter.jpa;

import com.saludsystem.submodules.core.principal.adapter.entity.AseguradoraEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AseguradoraJpaRepository extends JpaRepository<AseguradoraEntity, UUID> {
    Page<AseguradoraEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}
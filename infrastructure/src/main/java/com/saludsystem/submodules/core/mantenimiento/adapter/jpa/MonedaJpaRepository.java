package com.saludsystem.submodules.core.mantenimiento.adapter.jpa;

import com.saludsystem.submodules.core.mantenimiento.adapter.entity.MonedaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MonedaJpaRepository extends JpaRepository<MonedaEntity, UUID> {
    Page<MonedaEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}
package com.saludsystem.submodules.core.movimiento.adapter.jpa;

import com.saludsystem.submodules.core.movimiento.adapter.entity.InventarioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InventarioJpaRepository extends JpaRepository<InventarioEntity, UUID> {
    Page<InventarioEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}
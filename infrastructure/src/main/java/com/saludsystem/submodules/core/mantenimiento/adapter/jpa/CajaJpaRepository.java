package com.saludsystem.submodules.core.mantenimiento.adapter.jpa;

import com.saludsystem.submodules.core.mantenimiento.adapter.entity.CajaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CajaJpaRepository extends JpaRepository<CajaEntity, UUID> {
    Page<CajaEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}
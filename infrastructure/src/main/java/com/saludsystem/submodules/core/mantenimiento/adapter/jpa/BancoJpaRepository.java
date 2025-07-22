package com.saludsystem.submodules.core.mantenimiento.adapter.jpa;

import com.saludsystem.submodules.core.mantenimiento.adapter.entity.BancoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BancoJpaRepository extends JpaRepository<BancoEntity, UUID> {
    Page<BancoEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}
package com.saludsystem.submodules.core.principal.adapter.jpa;

import com.saludsystem.submodules.core.principal.adapter.entity.EmpresaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmpresaJpaRepository extends JpaRepository<EmpresaEntity, UUID> {
    Page<EmpresaEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}
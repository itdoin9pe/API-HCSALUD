package com.saludsystem.submodules.core.catalogo.adapter.jpa;

import com.saludsystem.submodules.core.catalogo.adapter.entity.ConsentimientoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConsentimientoJpaRepository extends JpaRepository<ConsentimientoEntity, UUID> {
    Page<ConsentimientoEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
    long countByHospital_HospitalId(UUID hospitalId);
}
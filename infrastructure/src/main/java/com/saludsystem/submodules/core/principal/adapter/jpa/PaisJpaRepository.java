package com.saludsystem.submodules.core.principal.adapter.jpa;

import com.saludsystem.submodules.core.principal.adapter.entity.PaisEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaisJpaRepository extends JpaRepository<PaisEntity, Integer> {

    Page<PaisEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
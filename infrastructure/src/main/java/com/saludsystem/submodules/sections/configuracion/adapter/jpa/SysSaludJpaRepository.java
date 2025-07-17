package com.saludsystem.submodules.sections.configuracion.adapter.jpa;

import com.saludsystem.submodules.sections.configuracion.adapter.entity.SysSaludEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SysSaludJpaRepository extends JpaRepository<SysSaludEntity, UUID> {

    Page<SysSaludEntity> findByHospitalId(UUID hospitalId, Pageable pageable);

}
package com.saludsystem.configuracion.infrastructure.adapters.out.persistance;

import com.saludsystem.configuracion.domain.model.SysSaludEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SysSaludRepository extends JpaRepository<SysSaludEntity, UUID> {

    Page<SysSaludEntity> findByHospitalId(UUID hospitalId, Pageable pageable);

}
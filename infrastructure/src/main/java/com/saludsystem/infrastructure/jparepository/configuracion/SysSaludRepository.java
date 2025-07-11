package com.saludsystem.infrastructure.jparepository.configuracion;

import com.configuracion.domain.model.SysSaludEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SysSaludRepository extends JpaRepository<SysSaludEntity, UUID> {

    Page<SysSaludEntity> findByHospitalId(UUID hospitalId, Pageable pageable);

}
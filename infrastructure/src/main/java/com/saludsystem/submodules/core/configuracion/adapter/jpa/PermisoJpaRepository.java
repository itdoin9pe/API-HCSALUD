package com.saludsystem.submodules.core.configuracion.adapter.jpa;

import com.saludsystem.submodules.core.configuracion.adapter.entity.PermisoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PermisoJpaRepository extends JpaRepository<PermisoEntity, UUID> {

    Page<PermisoEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
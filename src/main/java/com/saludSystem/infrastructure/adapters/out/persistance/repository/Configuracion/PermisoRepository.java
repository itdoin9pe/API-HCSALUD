package com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion;

import com.saludSystem.domain.model.Configuracion.PermisoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PermisoRepository extends JpaRepository<PermisoEntity, UUID> {

    List<PermisoEntity> findByHospitalHospitalId(UUID hospitalId);

    Page<PermisoEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
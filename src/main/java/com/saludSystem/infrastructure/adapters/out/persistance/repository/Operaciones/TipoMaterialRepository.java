package com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones;

import com.saludSystem.domain.model.Operaciones.TipoMaterialEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoMaterialRepository extends JpaRepository<TipoMaterialEntity, UUID> {

    Page<TipoMaterialEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
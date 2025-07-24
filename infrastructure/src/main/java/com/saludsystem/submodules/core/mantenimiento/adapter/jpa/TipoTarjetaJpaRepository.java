package com.saludsystem.submodules.core.mantenimiento.adapter.jpa;

import com.saludsystem.submodules.core.mantenimiento.adapter.entity.TipoTarjetaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoTarjetaJpaRepository extends JpaRepository<TipoTarjetaEntity, UUID> {
    Page<TipoTarjetaEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}
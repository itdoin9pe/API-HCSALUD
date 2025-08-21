package com.saludsystem.submodules.core.movimiento.adapter.jpa;

import com.saludsystem.submodules.core.movimiento.adapter.entity.CompraDetalleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface CompraDetalleJpaRepository extends JpaRepository<CompraDetalleEntity, UUID> {

    Page<CompraDetalleEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
package com.saludsystem.movimientos.infrastructure.adapters.out.persistance;

import com.saludsystem.movimientos.domain.model.CompraDetalleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface CompraDetalleRepository extends JpaRepository<CompraDetalleEntity, UUID> {

    Page<CompraDetalleEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
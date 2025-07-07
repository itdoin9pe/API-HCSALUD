package com.saludsystem.movimientos.infrastructure.adapters.out.persistance;

import com.saludsystem.movimientos.domain.model.VentaDetalleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface VentaDetalleRepository extends JpaRepository<VentaDetalleEntity, UUID> {

    Page<VentaDetalleEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
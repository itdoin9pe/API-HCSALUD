package com.saludsystem.infrastructure.adapter.jparepository.movimiento;

import com.saludsystem.infrastructure.adapter.entity.movimiento.CompraDetalleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface CompraDetalleJpaRepository extends JpaRepository<CompraDetalleEntity, UUID> {

    Page<CompraDetalleEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
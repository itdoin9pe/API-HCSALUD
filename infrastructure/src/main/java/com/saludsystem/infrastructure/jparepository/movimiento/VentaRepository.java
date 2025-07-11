package com.saludsystem.infrastructure.jparepository.movimiento;

import com.saludsystem.movimientos.domain.model.VentaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface VentaRepository extends JpaRepository<VentaEntity, UUID> {

    Page<VentaEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
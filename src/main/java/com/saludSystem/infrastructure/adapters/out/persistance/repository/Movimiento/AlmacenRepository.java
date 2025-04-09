package com.saludSystem.infrastructure.adapters.out.persistance.repository.Movimiento;

import com.saludSystem.domain.model.Movimientos.AlmacenEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlmacenRepository extends JpaRepository<AlmacenEntity, UUID> {

    Page<AlmacenEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
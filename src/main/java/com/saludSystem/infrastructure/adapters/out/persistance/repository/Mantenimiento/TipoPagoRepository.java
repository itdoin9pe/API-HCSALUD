package com.saludSystem.infrastructure.adapters.out.persistance.repository.Mantenimiento;

import com.saludSystem.domain.model.Mantenimiento.TipoPagoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TipoPagoRepository extends JpaRepository<TipoPagoEntity, UUID> {

    Page<TipoPagoEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
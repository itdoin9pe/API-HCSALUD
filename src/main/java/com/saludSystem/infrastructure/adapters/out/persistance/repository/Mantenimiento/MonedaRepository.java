package com.saludSystem.infrastructure.adapters.out.persistance.repository.Mantenimiento;

import com.saludSystem.domain.model.Mantenimiento.MonedaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MonedaRepository extends JpaRepository<MonedaEntity, UUID> {

    Page<MonedaEntity> findByHospital_HospitalId(UUID monedaId, Pageable pageable);

}
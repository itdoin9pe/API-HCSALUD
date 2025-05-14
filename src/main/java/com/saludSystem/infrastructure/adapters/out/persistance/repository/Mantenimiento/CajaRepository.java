package com.saludSystem.infrastructure.adapters.out.persistance.repository.Mantenimiento;

import com.saludSystem.domain.model.Mantenimiento.CajaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CajaRepository extends JpaRepository<CajaEntity, UUID> {

    Page<CajaEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
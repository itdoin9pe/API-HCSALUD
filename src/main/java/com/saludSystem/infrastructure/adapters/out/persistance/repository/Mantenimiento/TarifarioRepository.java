package com.saludSystem.infrastructure.adapters.out.persistance.repository.Mantenimiento;

import com.saludSystem.domain.model.Mantenimiento.TarifarioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TarifarioRepository extends JpaRepository<TarifarioEntity, UUID> {

    Page<TarifarioEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
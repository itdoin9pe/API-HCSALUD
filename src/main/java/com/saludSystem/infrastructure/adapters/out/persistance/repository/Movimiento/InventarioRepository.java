package com.saludSystem.infrastructure.adapters.out.persistance.repository.Movimiento;

import com.saludSystem.domain.model.Movimientos.InventarioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InventarioRepository extends JpaRepository<InventarioEntity, UUID> {

    Page<InventarioEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);
    //Page<InventarioEntity> findByAlmacenEntity_Hospital_HospitalId(UUID hospitalId, Pageable pageable);

}
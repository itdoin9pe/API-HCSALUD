package com.saludsystem.submodules.adapter.jpa.interfaces.movimiento;

import com.saludsystem.submodules.adapter.entity.movimiento.VentaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface VentaJpaRepository extends JpaRepository<VentaEntity, UUID> {

    Page<VentaEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
package com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.estadocuenta;

import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.estadocuenta.EPagoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EPagoJpaRepository extends JpaRepository<EPagoEntity, UUID> {

    Page<EPagoEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);

}
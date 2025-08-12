package com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.tratamiento;

import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.tratamiento.ProcedimientoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProcedimientoJpaRepository extends JpaRepository<ProcedimientoEntity, UUID> {
    Page<ProcedimientoEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}
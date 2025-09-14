package com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.tratamiento;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.tratamiento.CostoTratamientoEntity;

@Repository
public interface CostoTratamientoJpaRepository extends JpaRepository<CostoTratamientoEntity, UUID>
{
	Page<CostoTratamientoEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}
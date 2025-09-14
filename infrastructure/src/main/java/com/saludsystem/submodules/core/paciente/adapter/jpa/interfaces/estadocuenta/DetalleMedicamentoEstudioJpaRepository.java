package com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.estadocuenta;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.estadocuenta.DetalleMedicamentosEstudiosEntity;

@Repository
public interface DetalleMedicamentoEstudioJpaRepository extends JpaRepository<DetalleMedicamentosEstudiosEntity, UUID>
{
	Page<DetalleMedicamentosEstudiosEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}
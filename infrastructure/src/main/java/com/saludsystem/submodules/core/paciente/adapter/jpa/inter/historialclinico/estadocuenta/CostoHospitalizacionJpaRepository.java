package com.saludsystem.submodules.core.paciente.adapter.jpa.inter.historialclinico.estadocuenta;

import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.estadocuenta.CostoHospitalizacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CostoHospitalizacionJpaRepository extends JpaRepository<CostoHospitalizacionEntity, UUID> {
}
package com.saludsystem.infrastructure.adapter.jparepository.paciente.historialclinico.estadocuenta;

import com.saludsystem.infrastructure.adapter.entity.paciente.historialclinico.estadocuenta.CostoHospitalizacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CostoHospitalizacionJpaRepository extends JpaRepository<CostoHospitalizacionEntity, UUID> {
}
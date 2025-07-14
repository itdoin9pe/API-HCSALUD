package com.saludsystem.infrastructure.adapter.jparepository.paciente.historialclinico.tratamiento;

import com.saludsystem.infrastructure.adapter.entity.paciente.historialclinico.tratamiento.CostoTratamientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CostoTratamientoJpaRepository extends JpaRepository<CostoTratamientoEntity, UUID> {

}
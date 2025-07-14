package com.saludsystem.infrastructure.adapter.jparepository.paciente.historialclinico.tratamiento;

import com.saludsystem.infrastructure.adapter.entity.paciente.historialclinico.tratamiento.PlanTratamientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlanTratamientoJpaRepository extends JpaRepository<PlanTratamientoEntity, UUID> {

}
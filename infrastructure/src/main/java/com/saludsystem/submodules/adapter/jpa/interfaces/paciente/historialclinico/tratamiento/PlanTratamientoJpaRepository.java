package com.saludsystem.submodules.adapter.jpa.interfaces.paciente.historialclinico.tratamiento;

import com.saludsystem.submodules.adapter.entity.paciente.historialclinico.tratamiento.PlanTratamientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlanTratamientoJpaRepository extends JpaRepository<PlanTratamientoEntity, UUID> {

}
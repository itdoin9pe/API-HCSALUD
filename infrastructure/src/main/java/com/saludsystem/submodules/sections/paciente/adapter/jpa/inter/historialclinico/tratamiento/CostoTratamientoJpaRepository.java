package com.saludsystem.submodules.sections.paciente.adapter.jpa.inter.historialclinico.tratamiento;

import com.saludsystem.submodules.sections.paciente.adapter.entity.historialclinico.tratamiento.CostoTratamientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CostoTratamientoJpaRepository extends JpaRepository<CostoTratamientoEntity, UUID> {

}
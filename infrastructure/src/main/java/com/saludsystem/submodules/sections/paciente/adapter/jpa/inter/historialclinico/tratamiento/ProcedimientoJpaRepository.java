package com.saludsystem.submodules.sections.paciente.adapter.jpa.inter.historialclinico.tratamiento;

import com.saludsystem.submodules.sections.paciente.adapter.entity.historialclinico.tratamiento.ProcedimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProcedimientoJpaRepository extends JpaRepository<ProcedimientoEntity, UUID> {

}
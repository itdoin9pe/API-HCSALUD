package com.saludsystem.submodules.adapter.jparepository.paciente.historialclinico.tratamiento;

import com.saludsystem.submodules.adapter.entity.paciente.historialclinico.tratamiento.ProcedimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProcedimientoJpaRepository extends JpaRepository<ProcedimientoEntity, UUID> {

}
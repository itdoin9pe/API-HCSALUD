package com.saludsystem.submodules.sections.paciente.adapter.jpa.inter.historialclinico;

import com.saludsystem.submodules.sections.paciente.adapter.entity.historialclinico.ExploracionFisicaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExploracionFisicaJpaRepository extends JpaRepository<ExploracionFisicaEntity, UUID> {

}
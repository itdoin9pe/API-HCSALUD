package com.saludsystem.submodules.adapter.jparepository.paciente.historialclinico;

import com.saludsystem.submodules.adapter.entity.paciente.historialclinico.ExploracionFisicaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExploracionFisicaJpaRepository extends JpaRepository<ExploracionFisicaEntity, UUID> {

}
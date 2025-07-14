package com.saludsystem.submodules.adapter.jparepository.paciente;

import com.saludsystem.submodules.adapter.entity.paciente.DiagnosticoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DiagnosticoJpaRepository extends JpaRepository<DiagnosticoEntity, UUID> {

}
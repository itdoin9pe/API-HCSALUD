package com.saludsystem.submodules.sections.paciente.adapter.jpa.inter;

import com.saludsystem.submodules.sections.paciente.adapter.entity.RecetaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RecetaJpaRepository extends JpaRepository<RecetaEntity, UUID> {

}
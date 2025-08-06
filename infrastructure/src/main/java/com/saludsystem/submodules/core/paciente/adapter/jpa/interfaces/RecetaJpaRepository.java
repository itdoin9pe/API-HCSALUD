package com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces;

import com.saludsystem.submodules.core.paciente.adapter.entity.RecetaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RecetaJpaRepository extends JpaRepository<RecetaEntity, UUID> {

}
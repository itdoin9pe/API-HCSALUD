package com.saludsystem.infrastructure.adapter.jparepository.paciente;

import com.saludsystem.infrastructure.adapter.entity.paciente.RecetaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RecetaJpaRepository extends JpaRepository<RecetaEntity, UUID> {

}
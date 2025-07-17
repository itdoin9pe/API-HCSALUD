package com.saludsystem.submodules.sections.operaciones.adapter.jpa;

import com.saludsystem.submodules.sections.operaciones.adapter.entity.MarcaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MarcaJpaRepository extends JpaRepository<MarcaEntity, UUID> {

}
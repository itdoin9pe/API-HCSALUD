package com.saludsystem.submodules.sections.operaciones.adapter.jpa;

import com.saludsystem.submodules.sections.operaciones.adapter.entity.TipoMaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoMaterialJpaRepository extends JpaRepository<TipoMaterialEntity, UUID> {

}
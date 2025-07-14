package com.saludsystem.submodules.adapter.jparepository.operaciones;

import com.saludsystem.submodules.adapter.entity.operaciones.TipoMaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoMaterialJpaRepository extends JpaRepository<TipoMaterialEntity, UUID> {

}
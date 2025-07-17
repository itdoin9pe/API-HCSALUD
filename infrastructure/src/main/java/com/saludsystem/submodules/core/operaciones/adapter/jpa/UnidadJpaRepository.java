package com.saludsystem.submodules.core.operaciones.adapter.jpa;

import com.saludsystem.submodules.core.operaciones.adapter.entity.UnidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UnidadJpaRepository extends JpaRepository<UnidadEntity, UUID> {

}
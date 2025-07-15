package com.saludsystem.submodules.adapter.jpa.interfaces.operaciones;

import com.saludsystem.submodules.adapter.entity.operaciones.UnidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UnidadJpaRepository extends JpaRepository<UnidadEntity, UUID> {

}
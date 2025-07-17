package com.saludsystem.submodules.sections.principal.adapter.jpa;

import com.saludsystem.submodules.sections.principal.adapter.entity.AseguradoraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AseguradoraJpaRepository extends JpaRepository<AseguradoraEntity, UUID> {

}
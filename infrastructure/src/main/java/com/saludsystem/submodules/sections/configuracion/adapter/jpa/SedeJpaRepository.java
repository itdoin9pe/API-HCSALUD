package com.saludsystem.submodules.sections.configuracion.adapter.jpa;


import com.saludsystem.submodules.sections.configuracion.adapter.entity.SedeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SedeJpaRepository extends JpaRepository<SedeEntity, UUID> {

}
package com.saludsystem.submodules.adapter.jparepository.configuracion;


import com.saludsystem.submodules.adapter.entity.configuracion.SedeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SedeJpaRepository extends JpaRepository<SedeEntity, UUID> {

}
package com.saludsystem.infrastructure.adapter.jparepository.configuracion;


import com.saludsystem.infrastructure.adapter.entity.configuracion.SedeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SedeJpaRepository extends JpaRepository<SedeEntity, UUID> {

}
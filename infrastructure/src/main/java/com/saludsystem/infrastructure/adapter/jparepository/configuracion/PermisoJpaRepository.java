package com.saludsystem.infrastructure.adapter.jparepository.configuracion;

import com.saludsystem.infrastructure.adapter.entity.configuracion.PermisoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PermisoJpaRepository extends JpaRepository<PermisoEntity, UUID> {

}
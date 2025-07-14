package com.saludsystem.infrastructure.adapter.jparepository.operaciones;

import com.saludsystem.infrastructure.adapter.entity.operaciones.MarcaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MarcaJpaRepository extends JpaRepository<MarcaEntity, UUID> {

}
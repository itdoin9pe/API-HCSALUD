package com.saludsystem.infrastructure.adapter.jparepository.operaciones;

import com.saludsystem.infrastructure.adapter.entity.operaciones.CategoriaMatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoriaMatJpaRepository extends JpaRepository<CategoriaMatEntity, UUID> {
}
package com.saludsystem.infrastructure.adapter.jparepository.principal;

import com.saludsystem.infrastructure.adapter.entity.principal.AseguradoraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AseguradoraJpaRepository extends JpaRepository<AseguradoraEntity, UUID> {

}
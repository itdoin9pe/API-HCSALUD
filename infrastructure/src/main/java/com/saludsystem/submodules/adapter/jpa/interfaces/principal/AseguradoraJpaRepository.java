package com.saludsystem.submodules.adapter.jpa.interfaces.principal;

import com.saludsystem.submodules.adapter.entity.principal.AseguradoraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AseguradoraJpaRepository extends JpaRepository<AseguradoraEntity, UUID> {

}
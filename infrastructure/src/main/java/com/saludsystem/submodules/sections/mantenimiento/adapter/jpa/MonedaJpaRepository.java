package com.saludsystem.submodules.sections.mantenimiento.adapter.jpa;

import com.saludsystem.submodules.sections.mantenimiento.adapter.entity.MonedaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MonedaJpaRepository extends JpaRepository<MonedaEntity, UUID> {

}
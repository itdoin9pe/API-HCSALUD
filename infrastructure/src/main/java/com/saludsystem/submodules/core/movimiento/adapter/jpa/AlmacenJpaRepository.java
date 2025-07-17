package com.saludsystem.submodules.core.movimiento.adapter.jpa;

import com.saludsystem.submodules.core.movimiento.adapter.entity.AlmacenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlmacenJpaRepository extends JpaRepository<AlmacenEntity, UUID> {

}
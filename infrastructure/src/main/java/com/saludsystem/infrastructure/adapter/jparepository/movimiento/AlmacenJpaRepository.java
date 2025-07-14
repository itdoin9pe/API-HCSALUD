package com.saludsystem.infrastructure.adapter.jparepository.movimiento;

import com.saludsystem.infrastructure.adapter.entity.movimiento.AlmacenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlmacenJpaRepository extends JpaRepository<AlmacenEntity, UUID> {

}
package com.saludsystem.submodules.adapter.jparepository.movimiento;

import com.saludsystem.submodules.adapter.entity.movimiento.AlmacenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlmacenJpaRepository extends JpaRepository<AlmacenEntity, UUID> {

}
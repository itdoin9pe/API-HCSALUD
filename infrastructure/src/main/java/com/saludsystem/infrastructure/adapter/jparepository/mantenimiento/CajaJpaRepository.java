package com.saludsystem.infrastructure.adapter.jparepository.mantenimiento;

import com.saludsystem.infrastructure.adapter.entity.mantenimiento.CajaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CajaJpaRepository extends JpaRepository<CajaEntity, UUID> {
}
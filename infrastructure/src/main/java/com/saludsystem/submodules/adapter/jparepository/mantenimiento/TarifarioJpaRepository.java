package com.saludsystem.submodules.adapter.jparepository.mantenimiento;

import com.saludsystem.submodules.adapter.entity.mantenimiento.TarifarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TarifarioJpaRepository extends JpaRepository<TarifarioEntity, UUID> {

}
package com.saludsystem.submodules.adapter.jparepository.mantenimiento;

import com.saludsystem.submodules.adapter.entity.mantenimiento.TipoPagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoPagoJpaRepository extends JpaRepository<TipoPagoEntity, UUID> {

}
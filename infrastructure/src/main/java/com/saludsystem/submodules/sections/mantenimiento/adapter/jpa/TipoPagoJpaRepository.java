package com.saludsystem.submodules.sections.mantenimiento.adapter.jpa;

import com.saludsystem.submodules.sections.mantenimiento.adapter.entity.TipoPagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoPagoJpaRepository extends JpaRepository<TipoPagoEntity, UUID> {

}
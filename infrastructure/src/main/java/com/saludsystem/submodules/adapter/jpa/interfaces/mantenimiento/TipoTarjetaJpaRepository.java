package com.saludsystem.submodules.adapter.jpa.interfaces.mantenimiento;

import com.saludsystem.submodules.adapter.entity.mantenimiento.TipoTarjetaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoTarjetaJpaRepository extends JpaRepository<TipoTarjetaEntity, UUID> {

}
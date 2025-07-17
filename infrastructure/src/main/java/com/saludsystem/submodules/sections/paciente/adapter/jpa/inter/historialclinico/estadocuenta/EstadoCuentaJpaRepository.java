package com.saludsystem.submodules.sections.paciente.adapter.jpa.inter.historialclinico.estadocuenta;

import com.saludsystem.submodules.sections.paciente.adapter.entity.historialclinico.estadocuenta.EstadoCuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstadoCuentaJpaRepository extends JpaRepository<EstadoCuentaEntity, UUID> {

}